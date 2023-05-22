package com.pnevsky.spring_rest.temperature_sensor.controllers;

import com.pnevsky.spring_rest.temperature_sensor.DTO.SensorDTO;
import com.pnevsky.spring_rest.temperature_sensor.models.Sensor;
import com.pnevsky.spring_rest.temperature_sensor.utils.SensorValidator;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sensors")
public class SensorsController {

    private final ModelMapper modelMapper;
    private final SensorValidator sensorValidator;

    @Autowired
    public SensorsController(ModelMapper modelMapper, SensorValidator sensorValidator) {
        this.modelMapper = modelMapper;
        this.sensorValidator = sensorValidator;
    }


    @PostMapping ("/registration")
    public ResponseEntity<HttpStatus> sensorRegistration(
            @RequestBody @Valid SensorDTO sensorDTO, BindingResult bindingResult) {
        Sensor newSensor = converToSensor(sensorDTO);
        sensorValidator.validate(newSensor, bindingResult);




        return ;
    }

    private Sensor converToSensor(SensorDTO sensorDTO) {
        modelMapper.map(sensorDTO, Sensor.class);
    }










}
