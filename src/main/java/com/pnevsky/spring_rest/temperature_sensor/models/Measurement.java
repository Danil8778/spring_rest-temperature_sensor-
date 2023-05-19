package com.pnevsky.spring_rest.temperature_sensor.models;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Value;

@Table(name = "Measurement")
public class Measurement {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "sensor")
    private Sensor sensor;

    @NotEmpty(message = "The field should not be empty")
    @Size(min = -100, max = 100, message = "Incorrect temperature")
    @Column(name = "value")
    private long value;

    @Column(name = "raining")
    @NotEmpty(message = "The field should not be empty")
    private boolean raining;


    public Measurement(long value, boolean raining) {
        this.value = value;
        this.raining = raining;
    }

    public Measurement() {
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public boolean isRaining() {
        return raining;
    }

    public void setRaining(boolean rain) {
        this.raining = rain;
    }
}
