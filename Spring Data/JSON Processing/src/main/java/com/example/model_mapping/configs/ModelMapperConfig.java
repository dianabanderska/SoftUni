package com.example.model_mapping.configs;

import com.example.model_mapping.models.dto.EmployeeDto;
import com.example.model_mapping.models.entities.Employee;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.addMappings(new PropertyMap<Employee, EmployeeDto>() {
            @Override
            protected void configure() {
                map().setIncome(source.getSalary());
            }
        });

        return mapper;
    }
}
