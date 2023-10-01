package com.example.haksa.service;

import com.example.haksa.entity.Event;
import com.example.haksa.repository.EventRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public void crawlAndSaveData() {
        Document docu = null;
        final String url = "https://web.kangnam.ac.kr/menu/02be162adc07170ec7ee034097d627e9.do";
        try {
            docu = Jsoup.connect(url).get();

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (docu != null) {
            Elements dateElements = docu.select("th.text-center");
            Elements scheduleElements = docu.select(".text-center.last");

            int size = Math.min(dateElements.size(), scheduleElements.size());

            for (int i = 0; i < size; i++) {
                String date = dateElements.get(i).text();
                String schedule = scheduleElements.get(i).text();

                if (!date.contains("날짜") && !date.contains("일정내용") &&
                        !schedule.contains("날짜") && !schedule.contains("일정내용")) {

                    Event event = new Event();
                    event.setDate(date);
                    event.setSchedule(schedule);
                    eventRepository.save(event);
                    System.out.println("Date Elements: " + dateElements);
                    System.out.println("Schedule Elements: " + scheduleElements);
                }
            }
        }
    }

}
