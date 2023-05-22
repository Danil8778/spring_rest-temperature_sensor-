package com.pnevsky.spring_rest.temperature_sensor.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/measurements")
public class MeasurementsController {

    @PostMapping("/add")
    @ResponseBody
    public String addMeasurement(){
        return "measurements/add";
    }

    @GetMapping()
    public String getMeasurements(){
        return "index";
    }

    @GetMapping("/rainyDays")
    public String getRainyDays(){
        return "index";
    }
}
