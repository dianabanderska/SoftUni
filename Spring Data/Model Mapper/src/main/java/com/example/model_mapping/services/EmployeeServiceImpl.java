package com.example.model_mapping.services;

import com.example.model_mapping.models.dto.ManagerDto;
import com.example.model_mapping.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final ModelMapper mapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper mapper) {
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }

    @Override
    public ManagerDto findOne(Long id) {
        return mapper.map(this.employeeRepository.findById(id).orElseThrow(),
                ManagerDto.class); 
    }

    @Override
    public List<ManagerDto> findAll() {
        return mapper.map(this.employeeRepository.findAll(),
                new TypeToken<List<ManagerDto>>() {
                }.getType());
    }
}
