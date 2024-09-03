package com.bankaccount.cs425bank.controller;

import com.bankaccount.cs425bank.dto.RequestDto.AccountRequestDto;
import com.bankaccount.cs425bank.dto.ResponseDto.AccountWithCustomerResponse;
import com.bankaccount.cs425bank.dto.ResponseDto.CustomerWithAccounts;
import com.bankaccount.cs425bank.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/accounts")

public class AccountController {

    private final AccountService accountService;



    @GetMapping("/platinum-accounts")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountWithCustomerResponse> getPlatinumAccounts(@RequestParam("year") int year,
                                                                 @RequestParam("status") String status){
       return accountService.getPlatinumAccounts(year, status);

    }

    @PostMapping("/customers/{customerId}/accounts")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerWithAccounts createAccountForCustomer(@PathVariable("customerId") Integer customerId,
                                                         @RequestBody @Valid AccountRequestDto accountRequestDto){
        return accountService.createAccountForCustomer(customerId,accountRequestDto);
    }




}
