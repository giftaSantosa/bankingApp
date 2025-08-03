package com.example.bankingApp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.bankingApp.dto.AccountDto;
import com.example.bankingApp.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;
    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AccountDto addAccount(@RequestBody AccountDto accountDto){
        return accountService.createAccount(accountDto);
    }

    @GetMapping("{id}")
    public AccountDto getAccount(@PathVariable Long id){
        return accountService.getAccountById(id);
    }

    @PutMapping("{id}/deposit")
    public AccountDto depositBalance(@PathVariable("id") Long id, @RequestBody Map<String, Double> balance){
        double amount = balance.get("deposit");
        return accountService.addDeposit(id, amount);
    }

    @PutMapping("{id}/withdraw")
    public AccountDto withdrawBalance(@PathVariable("id") Long id, @RequestBody Map<String, Double> balance){
        double amount = balance.get("withdraw");
        return accountService.withdraw(id, amount);
    }

    @GetMapping("getAccounts")
    public List<AccountDto> getAllAccounts() {
        return accountService.getAccounts();
    }

    @DeleteMapping("delete/{id}")
    public String deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return "Account is deleted successfully!";
    }

}



