package com.example.shedule.entities;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

public class Schedule {
    private int COUNTER = 0;

    private int Id;
    private String name;
    private LocalTime timeStart;
    private LocalTime timeEnd;
    private List<DayOfWeek> days;


    public Schedule(String name, LocalTime timeStart, LocalTime timeEnd, List<DayOfWeek> days) {
        this.Id = ++COUNTER;
        this.name = name;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.days = days;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalTime getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(LocalTime timeStart) {
        this.timeStart = timeStart;
    }

    public LocalTime getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(LocalTime timeEnd) {
        this.timeEnd = timeEnd;
    }

    public List<DayOfWeek> getDays() {
        return days;
    }

    public void setDays(List<DayOfWeek> days) {
        this.days = days;
    }
}
