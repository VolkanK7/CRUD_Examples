package com.example.usertrials.service;

import com.example.usertrials.dto.AccountDto;
import com.example.usertrials.model.Account;
import com.example.usertrials.model.Customer;
import com.example.usertrials.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final CustomerService customerService;

    private AccountDto convert(Account account){
        AccountDto accountDto = new AccountDto();
        accountDto.setId(account.getId());
        accountDto.setAccountName(account.getAccountName());
        accountDto.setAccountType(account.getAccountType());
        accountDto.setCustomerId(account.getCustomer().getId());
        return accountDto;
    }

    public AccountService(AccountRepository accountRepository,CustomerService customerService) {
        this.customerService = customerService;
        this.accountRepository = accountRepository;
    }

   /* public List<Account> getAllAccountsById(Optional<Integer> customerId) {
        if(customerId.isPresent())
            return this.accountRepository.findByCustomerId(customerId.get());
        return null;
    } */

    public Account createAccount(AccountDto accountDto) {
        Customer customer = this.customerService.getCustomerById(accountDto.getCustomerId());
        if(customer == null)
            return null;
        Account account = new Account();
        account.setId(accountDto.getId());
        account.setAccountName(accountDto.getAccountName());
        account.setAccountType(accountDto.getAccountType());
        account.setCustomer(customer);
        return this.accountRepository.save(account);

    }

    public Account updateAccount(int id, AccountDto accountDto) {
        Optional<Account> account = accountRepository.findById(id);
        if(account.isPresent()){
            Account toUpdate = account.get();
            toUpdate.setAccountType(accountDto.getAccountType());
            toUpdate.setAccountName(accountDto.getAccountName());
            this.accountRepository.save(toUpdate);
            return toUpdate;
        }
        return null;

    }

    public void deleteAccount(int id) {
        this.accountRepository.deleteById(id);
    }

    public List<AccountDto> getAllAccounts() {
        return this.accountRepository.findAll().stream().map(this::convert).collect(Collectors.toList());
    }

    public List<AccountDto> getAllAccountsById(int customerId) {
        return null;
    }

    public Account updateAccountByCustomerId(int id, AccountDto accountDto) {
       // Customer customer = this.customerService.getCustomerById(accountDto.getCustomerId());
        Customer customer = customerService.getCustomerById(id);
        if(customer == null)
            return null;
        Account toUpdate = new Account();
        toUpdate.setAccountType(accountDto.getAccountType());
        toUpdate.setAccountName(accountDto.getAccountName());
        this.accountRepository.save(toUpdate);
        return toUpdate;
    }
}
