package com.pnevsky.spring_rest.temperature_sensor.controllers;

import com.pnevsky.spring_rest.temperature_sensor.DTO.SensorDTO;
import com.pnevsky.spring_rest.temperature_sensor.models.Sensor;
import com.pnevsky.spring_rest.temperature_sensor.services.SensorService;
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
    private final SensorService sensorService;

    @Autowired
    public SensorsController(ModelMapper modelMapper, SensorValidator sensorValidator, SensorService sensorService) {
        this.modelMapper = modelMapper;
        this.sensorValidator = sensorValidator;
        this.sensorService = sensorService;
    }


    @PostMapping ("/registration")
    public ResponseEntity<HttpStatus> sensorRegistration(
            @RequestBody @Valid SensorDTO sensorDTO, BindingResult bindingResult) {
        Sensor newSensor = converToSensor(sensorDTO);
        sensorValidator.validate(newSensor, bindingResult);

        if(bindingResult.hasErrors())
            throw new RuntimeException();

        sensorService.register(newSensor);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    private Sensor converToSensor(SensorDTO sensorDTO) {
        return modelMapper.map(sensorDTO, Sensor.class);
    }
}
