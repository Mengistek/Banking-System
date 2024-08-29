package com.bankaccount.cs425bank.service;

import com.bankaccount.cs425bank.dto.AccountRequestDto;
import com.bankaccount.cs425bank.dto.AccountResponseDTO;
import com.bankaccount.cs425bank.dto.CustomerRequestDTO;
import com.bankaccount.cs425bank.dto.CustomerResponseDTO;

import java.util.List;


public interface AccountServiceImp {
    CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequestDTO);
    AccountResponseDTO createAccountForCustomer(Integer customerId, AccountRequestDto accountRequestDto);
    CustomerResponseDTO getCustomerById(Integer customerId);
    List<AccountResponseDTO> getPlatinumAccounts();
}
