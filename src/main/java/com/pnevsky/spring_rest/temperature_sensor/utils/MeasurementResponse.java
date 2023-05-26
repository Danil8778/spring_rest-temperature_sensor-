package com.pnevsky.spring_rest.temperature_sensor.utils;

import com.pnevsky.spring_rest.temperature_sensor.DTO.MeasurementDTO;

import java.util.List;

public class MeasurementResponse {

    private List<MeasurementDTO> measurementDTOList;

    public MeasurementResponse(List<MeasurementDTO> measurementDTOList) {
        this.measurementDTOList = measurementDTOList;
    }

    public List<MeasurementDTO> getMeasurementDTOList() {
        return measurementDTOList;
    }

    public void setMeasurementDTOList(List<MeasurementDTO> measurementDTOList) {
        this.measurementDTOList = measurementDTOList;
    }
}
