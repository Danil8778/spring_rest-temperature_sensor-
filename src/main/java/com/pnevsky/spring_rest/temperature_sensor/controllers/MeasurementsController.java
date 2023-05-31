package com.pnevsky.spring_rest.temperature_sensor.controllers;

import com.pnevsky.spring_rest.temperature_sensor.DTO.MeasurementDTO;
import com.pnevsky.spring_rest.temperature_sensor.models.Measurement;
import com.pnevsky.spring_rest.temperature_sensor.services.MeasurementService;
import com.pnevsky.spring_rest.temperature_sensor.utils.MeasurementResponse;
import com.pnevsky.spring_rest.temperature_sensor.utils.MeasurementValidator;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/measurements")
public class MeasurementsController {

    private final ModelMapper modelMapper;
    private final MeasurementService measurementService;
    private final MeasurementValidator measurementValidator;

    @Autowired
    public MeasurementsController(ModelMapper modelMapper, MeasurementService measurementService, MeasurementValidator measurementValidator) {
        this.modelMapper = modelMapper;
        this.measurementService = measurementService;
        this.measurementValidator = measurementValidator;
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addMeasurement(
            @RequestBody @Valid MeasurementDTO measurementDTO, BindingResult bindingResult){
        Measurement newMeasurement = converToMeasurement(measurementDTO);
        measurementValidator.validate(newMeasurement, bindingResult);

        if(bindingResult.hasErrors())
            throw new RuntimeException();
        measurementService.addMeasurement(newMeasurement);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping()
    public MeasurementResponse getMeasurements(){
        return new MeasurementResponse(measurementService.findAll().stream().map(this::convertToMeasurementDTO)
                .collect(Collectors.toList()));
    }

    @GetMapping("/rainyDays")
    public Long getRainyDays(){
        return measurementService.findAll().stream()
                .filter(Measurement::isRaining).count();
    }

    private Measurement converToMeasurement(MeasurementDTO measurementDTO) {
        return modelMapper.map(measurementDTO, Measurement.class);
    }

    private MeasurementDTO convertToMeasurementDTO(Measurement measurement){
        return modelMapper.map(measurement, MeasurementDTO.class);
    }
}



