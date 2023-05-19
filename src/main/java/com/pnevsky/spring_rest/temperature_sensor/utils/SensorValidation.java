package com.pnevsky.spring_rest.temperature_sensor.utils;

import com.pnevsky.spring_rest.temperature_sensor.models.Sensor;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class SensorValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Sensor.class);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
