package com.pnevsky.spring_rest.temperature_sensor.models;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.annotations.AnyDiscriminator;
import org.hibernate.annotations.BatchSize;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Table(name = "Sensors")
public class Sensor {

    @Column(name = "name")
    @NotEmpty(message = "The field should not be empty")
    @Length(min = 3, max = 30, message = "Incorrect name length")
    private String name;

    public Sensor(String name) {
        this.name = name;
    }

    public Sensor() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
