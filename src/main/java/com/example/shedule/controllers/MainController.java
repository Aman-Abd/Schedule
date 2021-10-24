package com.example.shedule.controllers;

import com.example.shedule.entities.Schedule;
import com.example.shedule.repository.ScheduleRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("schedule")
@Api(value = "Schedule Controller class", description = "This class allows to interact with Schedule object")
public class MainController {
    @Autowired
    private ScheduleRepository scheduleRepository;

    @GetMapping("{id}")
    @ApiOperation(value = "Method to get schedule", response = List.class)
    public Optional<Schedule> getSchedule(@PathVariable int id){
        return scheduleRepository.findById(id);
    }

    @GetMapping
    @ApiOperation(value = "Method to get schedules", response = List.class)
    public List<Schedule> getSchedules(){
        return scheduleRepository.findAll();
    }

    @PostMapping("")
    @ApiOperation(value = "Method to add schedule", response = List.class)
    public void addSchedule(@RequestBody Schedule schedule){
        scheduleRepository.save(schedule);
    }

}
