package com.pnevsky.spring_rest.temperature_sensor.repositories;

import com.pnevsky.spring_rest.temperature_sensor.models.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {

}
