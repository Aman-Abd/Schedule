package com.example.shedule.controllers;

import com.example.shedule.database.DbService;
import com.example.shedule.entities.Schedule;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("schedule")
public class MainController {
    DbService dbService = new DbService();
    @GetMapping("{id}")
    public Schedule getSchedule(@PathVariable String id){
        return dbService.getScheduleById(Integer.parseInt(id));
    }

    @GetMapping
    public List<Schedule> getSchedules(){
        return dbService.getSchedules();
    }

    @PostMapping("/test")
    public boolean test (@RequestBody ){
        return true;
    }
}
