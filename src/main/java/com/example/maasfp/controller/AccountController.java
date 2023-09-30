package com.example.maasfp.controller;

import com.example.maasfp.model.Account;
import com.example.maasfp.repository.AccountRepository;
import com.example.maasfp.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;


import java.util.List;
import java.util.Optional;
/*
@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;
    // Save operation
    @PostMapping("/create_account")
    public Account saveAccount() {
        Account account = Account.builder()
                .username("Josef")
                .contactInfo("112")
                .accountType("ADMIN")
                .paymentInfo("112")
                .build();
        return accountService.saveAccount(account);
    }
}*/



@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {

        this.accountService = accountService;
    }

    @GetMapping("/")
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{accountId}")
    public Optional<Optional<Account>> getAccountById(@PathVariable("accountId") long accountId) {
        return Optional.ofNullable(accountService.getAccountById(accountId));
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {

        accountService.createAccount(account);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable("id") long accountId, @RequestBody Account account) {
        accountService.updateAccountById(accountId, account);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable("id") @RequestBody long accountId) {
        accountService.deleteAccountById(accountId);
        return new ResponseEntity<>("Account was deleted successfully", HttpStatus.OK);
    }


}
