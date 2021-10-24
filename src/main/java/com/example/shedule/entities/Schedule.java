package com.example.shedule.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name="schedules")
@Getter
@Setter

public class Schedule {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int Id;
    private String name;
    private LocalTime timeStart;
    private LocalTime timeEnd;
    private String dayOfWeek;

    public Schedule() {
    }

    public Schedule(String name, LocalTime timeStart, LocalTime timeEnd, String dayOfWeek) {
        this.name = name;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.dayOfWeek = dayOfWeek;
    }
}
