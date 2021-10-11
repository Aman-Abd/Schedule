package com.example.shedule.controllers;

import com.example.shedule.entities.Schedule;
import com.example.shedule.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("schedule")
public class MainController {
    @Autowired
    private ScheduleRepository scheduleRepository;

    @GetMapping("{id}")
    public Optional<Schedule> getSchedule(@PathVariable int id){
        return scheduleRepository.findById(id);
    }

    @GetMapping
    public List<Schedule> getSchedules(){
        return scheduleRepository.findAll();
    }

    @PostMapping("")
    public void addSchedule(@RequestBody Schedule schedule){
        scheduleRepository.save(schedule);
    }

}
