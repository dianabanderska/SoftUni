package com.example.spring_data_lab.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private BigDecimal balance;

    @ManyToOne
    private User user;

    public Account() {}

    public Account(BigDecimal balance, User user) {
        this.balance = balance;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public User getAccount() {
        return user;
    }

    public void setAccount(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
