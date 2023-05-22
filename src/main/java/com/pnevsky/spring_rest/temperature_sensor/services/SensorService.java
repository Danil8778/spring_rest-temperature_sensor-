package com.pnevsky.spring_rest.temperature_sensor.services;

import com.pnevsky.spring_rest.temperature_sensor.models.Sensor;
import com.pnevsky.spring_rest.temperature_sensor.repositories.SensorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SensorService {

    final private SensorRepository sensorRepository;


    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }




}
