package com.example.json_processing_ex.services;

import com.example.json_processing_ex.models.dto.UserSoldDto;
import com.example.json_processing_ex.models.entities.User;

import java.io.IOException;
import java.util.List;

public interface UserService {

    void seedUsers() throws IOException;

    User findRandomUser();

    List<UserSoldDto> findAllUsersWithMoreThanOneSoldProducts();
}
