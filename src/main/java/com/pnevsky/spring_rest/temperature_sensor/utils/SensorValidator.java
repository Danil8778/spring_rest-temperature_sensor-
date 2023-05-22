package com.pnevsky.spring_rest.temperature_sensor.utils;

import com.pnevsky.spring_rest.temperature_sensor.models.Sensor;
import com.pnevsky.spring_rest.temperature_sensor.services.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class SensorValidator implements Validator {

    private final SensorService sensorService;

    @Autowired
    public SensorValidator(SensorService sensorService){
        this.sensorService = sensorService;
    }
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Sensor.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Sensor sensor = (Sensor) target;
        if(sensorService.findByName(sensor.getName()).isPresent())
            errors.rejectValue("name", "This name is already present");
    }
}
