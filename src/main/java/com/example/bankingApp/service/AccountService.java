package com.example.bankingApp.service;

import java.util.List;

import com.example.bankingApp.dto.AccountDto;

public interface AccountService {
    
    AccountDto createAccount(AccountDto accountdto);

    AccountDto getAccountById(Long id);

    AccountDto addDeposit(Long id, double deposit);

    AccountDto withdraw(Long id, double amount);

    List<AccountDto> getAccounts();

    void deleteAccount(Long id);
} 