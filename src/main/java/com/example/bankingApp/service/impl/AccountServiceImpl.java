package com.example.bankingApp.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.bankingApp.Mapper.AccountMapper;
import com.example.bankingApp.dto.AccountDto;
import com.example.bankingApp.entity.Account;
import com.example.bankingApp.exception.AccountException;
import com.example.bankingApp.repository.AccountRepository;
import com.example.bankingApp.service.AccountService;

@Service //to automatically create a spring bean for the class
public class AccountServiceImpl implements AccountService{

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToDto(savedAccount);
        }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new AccountException("Account does not exist"));
        return AccountMapper.mapToDto(account);

        
    }

    @Override
    public AccountDto addDeposit(Long id, double deposit) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new AccountException("Account does not exist"));
        double total = account.getBalance() + deposit;
        account.setBalance(total);
        accountRepository.save(account);
        return AccountMapper.mapToDto(account);
        
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new AccountException("Account does not exist"));

        double balance = account.getBalance() - amount;
        account.setBalance(balance);
        accountRepository.save(account);
        return AccountMapper.mapToDto(account);
    
    }

    @Override
    public List<AccountDto> getAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map((account) -> AccountMapper.mapToDto(account)).collect(Collectors.toList());
    }

    @SuppressWarnings("unused")
    @Override
    public void deleteAccount(Long id) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new AccountException("Account does not exist"));
        accountRepository.deleteById(id);        
    }
}

    
