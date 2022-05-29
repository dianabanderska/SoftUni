package com.example.spring_data_lab;

import com.example.spring_data_lab.exceptions.InsufficientFundsException;
import com.example.spring_data_lab.exceptions.UsernameAlreadyExistsException;
import com.example.spring_data_lab.services.AccountService;
import com.example.spring_data_lab.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final UserService userService;
    private final AccountService accountService;

    @Autowired
    public ConsoleRunner(UserService userService, AccountService accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            this.userService.registerUser("Petar", 25, new BigDecimal(1000));
        } catch (UsernameAlreadyExistsException e) {
            System.out.println(e.getClass().getSimpleName());
        }

        this.userService.addAccount(new BigDecimal(500), 1);

        try {
            this.accountService.withdrawMoney(new BigDecimal(100), 1L);
        } catch (InsufficientFundsException e) {
            e.printStackTrace();
        }

        this.accountService.depositMoney(new BigDecimal(300), 2L);

        try {
            this.accountService.transferBetweenAccounts(1L, 2L, new BigDecimal(50));
        } catch (InsufficientFundsException e) {
            e.printStackTrace();
        }
    }
}
