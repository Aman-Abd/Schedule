package com.example.shedule.entities;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name="schedules")
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

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
}
