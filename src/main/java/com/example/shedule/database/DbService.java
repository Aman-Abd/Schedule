package com.example.shedule.database;

import com.example.shedule.entities.Schedule;

import java.util.List;

public class DbService {
    private DataBase dataBase = DataBase.getDataBase();

    public boolean add(Schedule schedule){
        try {
            dataBase.getSchedules().add(schedule);
            return true;
        }catch (Exception exception){
            return false;
        }
    }

    public List<Schedule> getSchedules(){
        return dataBase.getSchedules();
    }

    public Schedule getScheduleById(int id){
        return dataBase.getSchedules().stream().filter(schedule -> schedule.getId() == id).findFirst().orElseThrow();
    }

}
