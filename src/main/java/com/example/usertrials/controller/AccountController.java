package com.example.usertrials.controller;

import com.example.usertrials.dto.AccountDto;
import com.example.usertrials.model.Account;
import com.example.usertrials.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<AccountDto> getAllAccounts(){
        return this.accountService.getAllAccounts();
    }

    @GetMapping("/getall/{id}")
    public List<AccountDto> getAllAccountsById(@PathVariable int customerId){
        return this.accountService.getAllAccountsById(customerId);
    }

 /*   @GetMapping("/getall/{id}")
    public List<Account> getAllAccountsById(@RequestParam Optional<Integer> customerId){
        return this.accountService.getAllAccountsById(customerId);
    } */

    @PostMapping("/createaccount")
    public Account createAccount(@RequestBody AccountDto accountDto){
        return this.accountService.createAccount(accountDto);
    }

    @PutMapping("/updateById/{id}")
    public Account updateAccount(@PathVariable int id,@RequestBody AccountDto accountDto){
        return this.accountService.updateAccount(id,accountDto);
    }
    //Not working rn!
    @PutMapping("/updateByCustomerId/{id}")
    public Account updateAccountByCustomerId(@PathVariable int id,@RequestBody AccountDto accountDto){
        return this.accountService.updateAccountByCustomerId(id,accountDto);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteAccount(@PathVariable int id){
        this.accountService.deleteAccount(id);
    }
}
