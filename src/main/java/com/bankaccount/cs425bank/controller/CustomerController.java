package com.bankaccount.cs425bank.controller;

import com.bankaccount.cs425bank.dto.RequestDto.CustomerRequestDTO;
import com.bankaccount.cs425bank.dto.ResponseDto.CustomerResponseDTO;
import com.bankaccount.cs425bank.dto.ResponseDto.CustomerWithAccounts;
import com.bankaccount.cs425bank.service.CustomerServiceImp;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private  final CustomerServiceImp customerServiceImp;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponseDTO createCustomer(@RequestBody @Valid CustomerRequestDTO customerRequestDTO){
        return customerServiceImp.createCustomer(customerRequestDTO);
    }
    @GetMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerWithAccounts getCustomerById(@PathVariable("id") Integer id){
        return customerServiceImp.getCustomerById(id);
    }

}
