package com.example.usertrials.repository;

import com.example.usertrials.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account,Integer> {
    List<Account> findByCustomerId(Integer customerId);
}
