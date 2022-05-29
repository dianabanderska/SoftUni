package com.example.spring_data_lab.services;

import com.example.spring_data_lab.exceptions.UserNotFoundException;
import com.example.spring_data_lab.exceptions.UsernameAlreadyExistsException;
import com.example.spring_data_lab.models.Account;
import com.example.spring_data_lab.models.User;
import com.example.spring_data_lab.repositories.AccountRepository;
import com.example.spring_data_lab.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public void registerUser(String username, int age, BigDecimal initialAmount) throws UsernameAlreadyExistsException {
        if (this.userRepository.existsByUserName(username)) {
            throw new UsernameAlreadyExistsException();
        }

        User user = new User();
        user.setUserName(username);
        user.setAge(age);

        this.userRepository.save(user);

        this.saveAccount(initialAmount, user);
    }

    @Override
    public void addAccount(BigDecimal amount, long id) throws UserNotFoundException {
        User user = this.userRepository.findById(id).orElseThrow(UserNotFoundException::new);

        this.saveAccount(amount, user);
    }

    private void saveAccount(BigDecimal amount, User user) {
        Account account = new Account();
        account.setBalance(amount);
        account.setUser(user);
        this.accountRepository.save(account);
    }
}
