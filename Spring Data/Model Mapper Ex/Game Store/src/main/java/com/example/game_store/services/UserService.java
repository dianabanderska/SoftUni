package com.example.game_store.services;

import com.example.game_store.models.dto.UserLoginDto;
import com.example.game_store.models.dto.UserRegisterDto;

public interface UserService {

    void registerUser(UserRegisterDto userRegisterDto);

    void loginUser(UserLoginDto userLoginDto);

    void logout();
}
