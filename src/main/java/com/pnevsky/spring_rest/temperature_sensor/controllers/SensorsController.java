package com.pnevsky.spring_rest.temperature_sensor.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SensorsController {

    @PostMapping ("/sensors/registration")
    @ResponseBody()
    public String sensorRegistration() {

        return "sensors/registration";
    }

    @PostMapping("/measurements/add")
    @ResponseBody
    public String addMeasurement(){
        return "measurements/add";
    }

    @GetMapping("/measurements")
    public String getMeasurements(){
        return "index";
    }

    @GetMapping("measurements/rainyDays")
    public String getRainyDays(){
        return "index";
    }


}
