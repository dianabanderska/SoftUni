package com.example.model_mapping;

import com.example.model_mapping.models.dto.EmployeeDto;
import com.example.model_mapping.models.dto.ManagerDto;
import com.example.model_mapping.services.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final EmployeeService employeeService;

    public ConsoleRunner(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {
        ManagerDto managerDto = this.employeeService.findOne(1L);
        System.out.println(managerDto.getFirstName() + " " + managerDto.getLastName());
        managerDto.getSubordinates().forEach(employeeDto -> {
            System.out.println("\t" + employeeDto.getFirstName() + " " +
                    employeeDto.getLastName() + " " +
                    employeeDto.getIncome());
        });
    }
}
