package com.bankaccount.cs425bank.controller;

import com.bankaccount.cs425bank.dto.AccountRequestDto;
import com.bankaccount.cs425bank.dto.AccountResponseDTO;
import com.bankaccount.cs425bank.dto.CustomerRequestDTO;
import com.bankaccount.cs425bank.dto.CustomerResponseDTO;
import com.bankaccount.cs425bank.model.Customer;
import com.bankaccount.cs425bank.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/bank")

public class BankController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/platinum-accounts")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountResponseDTO> getPlatinumAccounts(){
        return accountService.getPlatinumAccounts();
    }

    @PostMapping("/customers/{customerId}/accounts")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountResponseDTO createAccountForCustomer(@PathVariable("customerId") Integer customerId, @RequestBody @Valid AccountRequestDto accountRequestDto){
        return accountService.createAccountForCustomer(customerId,accountRequestDto);
    }

    @GetMapping("/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponseDTO getCustomerById(@PathVariable Integer customerId){
        return accountService.getCustomerById(customerId);
    }
    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponseDTO createCustomer(@RequestBody @Valid CustomerRequestDTO customerRequestDTO){
        return accountService.createCustomer(customerRequestDTO);
    }


}
