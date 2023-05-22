package com.pnevsky.spring_rest.temperature_sensor.DTO;

import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

public class SensorDTO {

    @NotEmpty(message = "The field should not be empty")
    @Length(min = 3, max = 30, message = "Incorrect name length")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
