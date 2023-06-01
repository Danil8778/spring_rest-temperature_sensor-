package com.pnevsky.spring_rest.temperature_sensor.DTO;

import com.pnevsky.spring_rest.temperature_sensor.models.Sensor;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class MeasurementDTO {

    @NotNull
    private SensorDTO sensor;

    @NotNull(message = "The field should not be null")
    @Min(-100)
    @Max(100)
    private Double value;

    @NotNull(message = "The field should not be empty")
    private Boolean raining;

    public SensorDTO getSensor() {
        return sensor;
    }

    public void setSensor(SensorDTO sensor) {
        this.sensor = sensor;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Boolean getRaining() {
        return raining;
    }

    public void setRaining(Boolean raining) {
        this.raining = raining;
    }

}
