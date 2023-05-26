package com.pnevsky.spring_rest.temperature_sensor.services;

import com.pnevsky.spring_rest.temperature_sensor.models.Sensor;
import com.pnevsky.spring_rest.temperature_sensor.repositories.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class SensorService {

    final private SensorRepository sensorRepository;

    @Autowired
    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    public  Optional<Sensor> findByName(String name){
        return sensorRepository.findByName(name);
    };

    @Transactional
    public void register(Sensor sensor){
        sensorRepository.save(sensor);
    }




}
