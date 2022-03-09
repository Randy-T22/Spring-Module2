package com.example.demo.Transaction;

import com.example.demo.Account.Account;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String transactionType;

    private Integer transactionAmount;

    @JsonIgnore
    @ManyToMany(mappedBy = "previousTransactions")
    private Set<Account> accounts = new HashSet<>();

    public Long getId() {
        return id;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {this.transactionType = transactionType;}

    public Set<Account> getAccounts(){return accounts;}

}
