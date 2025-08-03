package com.example.bankingApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data //this automatically add constructor, getter, and setter methods
@AllArgsConstructor
public class AccountDto {
    private Long id;
    private String accountHolderName;
    private double balance;
}

//for Java 17 and above, we can utilize Record Class to automatically generate getter/setter, constructor, toStrings, hashCode, and equals

// public record AccountDto(Long id, String accountHolderName, double balance);