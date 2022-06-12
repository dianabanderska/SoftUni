package com.example.model_mapping;

import com.example.model_mapping.models.dto.EmployeeCreateRequest;
import com.example.model_mapping.models.dto.EmployeeCreateResponse;
import com.example.model_mapping.models.dto.ManagerDto;
import com.example.model_mapping.services.EmployeeService;
import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final EmployeeService employeeService;
    private final Gson gson;

    public ConsoleRunner(EmployeeService employeeService, Gson gson) {
        this.employeeService = employeeService;
        this.gson = gson;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String path;
        String line = scanner.nextLine();

        while (!line.equals("end")) {
            String[] cmdParts = line.split(" ", 2);

            switch (cmdParts[0]) {
                case "find":
                    Long id = Long.parseLong(cmdParts[1]);
                    ManagerDto managerById = employeeService.findOne(id);
                    String result = gson.toJson(managerById);
                    System.out.println(result);
                    break;

                case "findAll":
                    List<ManagerDto> allManagers = this.employeeService.findAll();
                    result = gson.toJson(allManagers);
                    System.out.println(result);
                    break;

                case "save":
                    String json = cmdParts[1];
                    EmployeeCreateRequest request =
                            gson.fromJson(json, EmployeeCreateRequest.class);

                    EmployeeCreateResponse response = employeeService.save(request);
                    System.out.println(gson.toJson(response));
                    break;

                case "save-from-file":
                    path = "src/main/resources/first-employee.json";
                    EmployeeCreateRequest fileRequest = gson.fromJson(new FileReader(path),
                            EmployeeCreateRequest.class);
                    EmployeeCreateResponse fileResponse = employeeService.save(fileRequest);
                    System.out.println(gson.toJson(fileResponse));
                    break;

                case "findAll-to":
                    path = "src/main/resources/findAll-first.json";
                    List<ManagerDto> managers = employeeService.findAll();

                    try (FileWriter fw = new FileWriter(path)){
                        gson.toJson(managers,
                                fw);

                        System.out.println("Written to file " + path);

                    }

                    break;
            }

            line = scanner.nextLine();
        }

        ManagerDto managerDto = employeeService.findOne(1L);
        System.out.println(managerDto.getFirstName() + " " + managerDto.getLastName());
        managerDto.getSubordinates().forEach(employeeDto -> {
            System.out.println("\t" + employeeDto.getFirstName() + " " +
                    employeeDto.getLastName() + " " +
                    employeeDto.getIncome());
        });
    }
}
