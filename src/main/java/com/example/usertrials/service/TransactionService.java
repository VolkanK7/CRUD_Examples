package com.example.usertrials.service;

import com.example.usertrials.model.Transaction;
import com.example.usertrials.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getTransactionById(Optional<Integer> accountId) {
        if (accountId.isPresent())
            return this.transactionRepository.findByAccountId(accountId.get());
        return null;
    }
}
