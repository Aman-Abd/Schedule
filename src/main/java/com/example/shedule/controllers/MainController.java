package com.example.shedule.controllers;

import com.example.shedule.entities.Schedule;
import com.example.shedule.repository.ScheduleRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
    @HystrixCommand(
            fallbackMethod = "getScheduleFallBack",
            threadPoolKey = "getSchedule",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="100"),
                    @HystrixProperty(name="maxQueueSize", value="50"),
            })
    public Optional<Schedule> getSchedule(@PathVariable int id){
        return scheduleRepository.findById(id);
    }

    public Optional<Schedule> getScheduleFallBack(@PathVariable int id){
        return null;
    }

    @GetMapping
    @ApiOperation(value = "Method to get schedules", response = List.class)
    @HystrixCommand(
            fallbackMethod = "getSchedulesFallBack",
            threadPoolKey = "getSchedules",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="100"),
                    @HystrixProperty(name="maxQueueSize", value="50"),
            })
    public List<Schedule> getSchedules(){
        return scheduleRepository.findAll();
    }

    public List<Schedule> getSchedulesFallBack(){
        return null;
    }

    @PostMapping("")
    @ApiOperation(value = "Method to add schedule", response = List.class)
    @HystrixCommand(
            fallbackMethod = "addScheduleFallBack",
            threadPoolKey = "addSchedule",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="100"),
                    @HystrixProperty(name="maxQueueSize", value="50"),
            })
    public void addSchedule(@RequestBody Schedule schedule){
        scheduleRepository.save(schedule);
    }

    public void addScheduleFallBack(@RequestBody Schedule schedule){
    }

}
