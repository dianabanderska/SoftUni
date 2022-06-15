package com.example.xml_processing_ex.services;

import com.example.xml_processing_ex.models.dto.UserSeedDto;
import com.example.xml_processing_ex.models.dto.UserViewRootDto;
import com.example.xml_processing_ex.models.entities.User;

import java.util.List;

public interface UserService {
    long getCount();

    void seedUsers(List<UserSeedDto> users);

    User getRandomUser();

    UserViewRootDto findUsersWithMoreThanOneSoldProduct();
}
