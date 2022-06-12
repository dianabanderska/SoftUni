package com.example.model_mapping.models.dto;

import com.google.gson.annotations.Expose;

import java.util.Collections;
import java.util.List;

public class ManagerDto extends BasicEmployeeDto {

    @Expose
    private List<EmployeeDto> subordinates;

    public List<EmployeeDto> getSubordinates() {
        return Collections.unmodifiableList(subordinates);
    }

    public void setSubordinates(List<EmployeeDto> subordinates) {
        this.subordinates = subordinates;
    }
}
