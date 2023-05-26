package com.pnevsky.spring_rest.temperature_sensor.utils;

import com.pnevsky.spring_rest.temperature_sensor.models.Measurement;
import com.pnevsky.spring_rest.temperature_sensor.services.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class MeasurementValidator implements Validator {

    private final SensorService sensorService;

    @Autowired
    public MeasurementValidator(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Measurement.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Measurement measurement = (Measurement) target;

        if(sensorService.findByName(measurement.getSensor().getName()).isEmpty())
            errors.rejectValue("sensor","There is no registered service with this name");
    }
}
