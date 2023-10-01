package com.example.haksa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    private String schedule;

    public void setDate(String date) {
        this.date = date;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;

    }

}
