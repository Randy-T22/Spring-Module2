package com.example.demo.Account;

import com.example.demo.Customer.Customer;
import com.example.demo.Customer.CustomerRepository;
import com.example.demo.Transaction.Transaction;
import com.example.demo.Transaction.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping
    List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    @PostMapping
    Account createAccount(@RequestBody Account account) {
        return accountRepository.save(account);
    }

    @PutMapping("/{accountId}/transaction/{transactionId}")
    Account addAccountToCustomer(
            @PathVariable Long accountId,
            @PathVariable Long transactionId
    ) {
        Account account = accountRepository.findById(accountId).get();
        Transaction transaction = transactionRepository.findById(transactionId).get();
        account.previousTransactions.add(transaction);
        return accountRepository.save(account);
    }

    @PutMapping("/{accountId}/customer/{customerId}")
    Account assignTeacherToSubject(
            @PathVariable Long accountId,
            @PathVariable Long customerId
    ) {
        Account account = accountRepository.findById(accountId).get();
        Customer customer = customerRepository.findById(customerId).get();
        account.setCustomer(customer);
        return accountRepository.save(account);
    }}