package com.example.shedule.database;

import com.example.shedule.entities.Schedule;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    static private DataBase dataBase;

    private List<Schedule> schedules = new ArrayList<Schedule>();

    private DataBase() {
        List<DayOfWeek> day = new ArrayList<>();
        day.add(DayOfWeek.FRIDAY);
        schedules.add(new Schedule("sadasd", LocalTime.now(), LocalTime.now(), day));
    }

    static public DataBase getDataBase(){
        if(dataBase == null)
            dataBase = new DataBase();
        return dataBase;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }
}
