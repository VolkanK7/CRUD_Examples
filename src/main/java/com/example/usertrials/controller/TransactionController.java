package com.example.usertrials.controller;

import com.example.usertrials.model.Transaction;
import com.example.usertrials.service.TransactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    @GetMapping("/getTransactionById/{id}")
    public List<Transaction> getTransactionById(@RequestParam Optional<Integer> accountId){
            return this.transactionService.getTransactionById(accountId);
    }
}
