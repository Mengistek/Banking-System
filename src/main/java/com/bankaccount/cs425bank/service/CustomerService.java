package com.bankaccount.cs425bank.service;

import com.bankaccount.cs425bank.dto.RequestDto.CustomerRequestDTO;
import com.bankaccount.cs425bank.dto.ResponseDto.CustomerResponseDTO;
import com.bankaccount.cs425bank.dto.ResponseDto.CustomerWithAccounts;


public interface CustomerService {
    CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequestDTO);
    CustomerWithAccounts getCustomerById(Integer customerId);

}
