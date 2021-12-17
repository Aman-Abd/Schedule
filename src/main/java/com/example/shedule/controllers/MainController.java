package com.example.shedule.controllers;

import com.example.shedule.entities.Schedule;
import com.example.shedule.repository.ScheduleRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
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
        return Optional.of(new Schedule("test", LocalTime.now(),LocalTime.now(),"test"));
    }

    public Optional<Schedule> getScheduleFallBack(@PathVariable int id){
        return Optional.of(new Schedule("test", LocalTime.now(),LocalTime.now(),"test"));
    }

    @GetMapping
    @ApiOperation(value = "Method to get schedules", response = ResponseEntity.class)
    @CrossOrigin(origins = "http://localhost:4200")
    @HystrixCommand(
            fallbackMethod = "getSchedulesFallBack",
            threadPoolKey = "getSchedules",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="100"),
                    @HystrixProperty(name="maxQueueSize", value="50"),
            })
    public ResponseEntity<?> getSchedules(){
        try{
            List<Schedule> schedules = scheduleRepository.findAll();
            return ResponseEntity.ok(schedules);
        }catch (Exception e){
            System.out.println("Error: " + e.toString());
            return null;
        }
    }

    public ResponseEntity<?> getSchedulesFallBack(){
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
