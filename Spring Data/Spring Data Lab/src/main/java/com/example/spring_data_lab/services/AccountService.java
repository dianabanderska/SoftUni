package com.example.spring_data_lab.services;

import com.example.spring_data_lab.exceptions.InsufficientFundsException;

import java.math.BigDecimal;

public interface AccountService {
    void withdrawMoney(BigDecimal amount, Long id) throws InsufficientFundsException;

    void depositMoney(BigDecimal amount, Long id);

    void transferBetweenAccounts(Long from, Long to, BigDecimal amount) throws InsufficientFundsException;
}
