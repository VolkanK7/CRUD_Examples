package com.example.usertrials.dto;

import com.example.usertrials.model.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private int id;
    private String accountType;
    private String accountName;
    private int customerId;
   // private Set<Transaction> transactions;
}
