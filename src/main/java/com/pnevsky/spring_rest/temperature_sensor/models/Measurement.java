package com.pnevsky.spring_rest.temperature_sensor.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Measurement")
public class Measurement {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "sensor")
    @ManyToOne
    @JoinColumn(name = "sensors", referencedColumnName = "name")
    private Sensor sensor;

    @NotNull(message = "The field should not be null")
    @Min(-100)
    @Max(100)
    @Column(name = "value")
    private Double value;

    @Column(name = "raining")
    @NotNull(message = "The field should not be empty")
    private Boolean raining;

    @Column(name = "measurement_time")
    @NotNull(message = "The field should not be empty")
    private LocalDateTime measurementTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Boolean isRaining() {
        return raining;
    }

    public void setRaining(Boolean raining) {
        this.raining = raining;
    }

    public LocalDateTime getMeasurementTime() {
        return measurementTime;
    }

    public void setMeasurementTime(LocalDateTime measurementTime) {
        this.measurementTime = measurementTime;
    }
}
