package com.bankaccount.cs425bank.service;

import com.bankaccount.cs425bank.dto.RequestDto.AccountRequestDto;
import com.bankaccount.cs425bank.dto.ResponseDto.AccountResponseDTO;
import com.bankaccount.cs425bank.dto.RequestDto.CustomerRequestDTO;
import com.bankaccount.cs425bank.dto.ResponseDto.AccountWithCustomerResponse;
import com.bankaccount.cs425bank.dto.ResponseDto.CustomerResponseDTO;
import com.bankaccount.cs425bank.dto.ResponseDto.CustomerWithAccounts;

import java.util.List;


public interface AccountServiceImp {
    CustomerWithAccounts createAccountForCustomer(Integer customerId, AccountRequestDto accountRequestDTO);

    List<AccountWithCustomerResponse> getPlatinumAccounts(int years, String status );

}
