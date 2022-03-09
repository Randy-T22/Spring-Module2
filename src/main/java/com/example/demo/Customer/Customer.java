package com.example.demo.Customer;

import com.example.demo.Account.Account;
import com.example.demo.Transaction.Transaction;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private Set<Account> accounts;

    private String name;

    private String password;

    private String address;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Account> getAccounts() {
        return this.accounts;
    }

//    @JsonIgnore
//    @OneToMany(mappedBy = "customer")
//    private Set<Transaction> transactions;
//
//    private String name;
//
//    private String password;
//
//
}
