package com.example.haksa;

import com.example.haksa.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrawtestApplication implements CommandLineRunner {

    @Autowired
    private EventService eventService;

    public static void main(String[] args) {
        SpringApplication.run(CrawtestApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        eventService.crawlAndSaveData();

    }
}
