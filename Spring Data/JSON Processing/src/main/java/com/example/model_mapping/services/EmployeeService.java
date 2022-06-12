package com.example.model_mapping.services;

import com.example.model_mapping.models.dto.EmployeeCreateRequest;
import com.example.model_mapping.models.dto.EmployeeCreateResponse;
import com.example.model_mapping.models.dto.ManagerDto;

import java.util.List;

public interface EmployeeService {

    ManagerDto findOne(Long id);

    List<ManagerDto> findAll();

    EmployeeCreateResponse save(EmployeeCreateRequest createRequest);
}
