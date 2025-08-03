package com.example.bankingApp.Mapper;

import com.example.bankingApp.dto.AccountDto;
import com.example.bankingApp.entity.Account;

public class AccountMapper {

    public static Account mapToAccount(AccountDto accountDto){
        Account account = new Account(
            accountDto.getId(), 
            accountDto.getAccountHolderName(),
            accountDto.getBalance()
        );
        return account;
    }

    // to utilize record class,
    // public static Account mapToAccount(AccountDto accountDto){
    //     Account account = new Account(
    //         accountDto.id(), 
    //         accountDto.accountHolderName(),
    //         accountDto.balance()
    //     );
    //     return account;

    public static AccountDto mapToDto(Account account){
        AccountDto accountDto = new AccountDto(
            account.getId(),
            account.getAccountHolderName(),
            account.getBalance()
        );
        return accountDto;
    } 
    
}
