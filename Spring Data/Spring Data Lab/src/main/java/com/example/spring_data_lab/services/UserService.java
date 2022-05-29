package com.example.spring_data_lab.services;

import com.example.spring_data_lab.exceptions.UserNotFoundException;
import com.example.spring_data_lab.exceptions.UsernameAlreadyExistsException;

import java.math.BigDecimal;

public interface UserService {
    void registerUser(String username, int age, BigDecimal initialAmount)
            throws UsernameAlreadyExistsException;

    void addAccount(BigDecimal amount, long id) throws UserNotFoundException;
}
