package com.example.spring_data_lab.services;

import com.example.spring_data_lab.exceptions.InsufficientFundsException;
import com.example.spring_data_lab.models.Account;
import com.example.spring_data_lab.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void withdrawMoney(BigDecimal amount, Long id) throws InsufficientFundsException {
        Account account = this.getAccount(id);
        throwIfInsufficientFunds(amount, account);

        account.setBalance(account.getBalance().subtract(amount));
        this.accountRepository.save(account);
    }

    private void throwIfInsufficientFunds(BigDecimal amount, Account account) throws InsufficientFundsException {
        if (account.getBalance().compareTo(amount) < 0) {
            throw new InsufficientFundsException();
        }
    }

    @Override
    public void depositMoney(BigDecimal amount, Long id) {
        Account account = this.getAccount(id);

        account.setBalance(account.getBalance().add(amount));
        this.accountRepository.save(account);

    }

    @Override
    @Transactional
    public void transferBetweenAccounts(Long fromId, Long toId, BigDecimal amount) throws InsufficientFundsException {
       this.withdrawMoney(amount, fromId);

       this.depositMoney(amount, toId);

    }

    private Account getAccount(Long id) {
        Account account = this.accountRepository.findById(id).orElseThrow();
        return account;
    }
}
