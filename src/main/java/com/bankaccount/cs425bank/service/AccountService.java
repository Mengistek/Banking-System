package com.bankaccount.cs425bank.service;

import com.bankaccount.cs425bank.dto.RequestDto.AccountRequestDto;
import com.bankaccount.cs425bank.dto.ResponseDto.AccountResponseDTO;
import com.bankaccount.cs425bank.dto.RequestDto.CustomerRequestDTO;
import com.bankaccount.cs425bank.dto.ResponseDto.AccountWithCustomerResponse;
import com.bankaccount.cs425bank.dto.ResponseDto.CustomerResponseDTO;
import com.bankaccount.cs425bank.dto.ResponseDto.CustomerWithAccounts;
import com.bankaccount.cs425bank.exception.CustomerNotFoundException;
import com.bankaccount.cs425bank.model.Account;
import com.bankaccount.cs425bank.model.Customer;
import com.bankaccount.cs425bank.repository.AccountRepository;
import com.bankaccount.cs425bank.repository.CustomerRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class AccountService implements AccountServiceImp{

    private final CustomerRepository customerRepository;

    private final ModelMapper modelMapper;

    private final AccountRepository accountRepository;
    @Override
    public List<AccountWithCustomerResponse> getPlatinumAccounts(int years,String active ) {
        List<Account> accounts = accountRepository.findAllAccountsDateCreatedGreaterThanFiveYearsAndActive(years,active);
           return  accounts.stream()
                   .map(account -> {
                       AccountWithCustomerResponse response = modelMapper.map(account, AccountWithCustomerResponse.class);
                       List<CustomerResponseDTO> customerResponses = account.getCustomers().stream()
                               .map(customer -> modelMapper.map(customer, CustomerResponseDTO.class))
                               .collect(Collectors.toList());  // Collect the mapped customers into a list
                       response.setCustomerResponses(customerResponses);  // Set the collected list
                       return response;
                   })
                   .collect(Collectors.toList());

    }
    @Override
    public CustomerWithAccounts createAccountForCustomer(Integer customerId, AccountRequestDto accountRequestDTO) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId));

        Account account =Account.builder()
                .accountNumber(accountRequestDTO.getAccountNumber())
                .dateOpened(accountRequestDTO.getDateOpened())
                .status(accountRequestDTO.getStatus())
                .balance(accountRequestDTO.getBalance())
                .accountType(accountRequestDTO.getAccountType())
                .build();
        //initialize the customer if it is null
        if (account.getCustomers() == null){
            account.setCustomers(new ArrayList<>());
        }
        //add the customer to the account's customer list
        account.getCustomers().add(customer);

        //add the account to the customer's account list
        if (customer.getAccounts() == null){
            customer.setAccounts(new ArrayList<>());
        }

        customer.getAccounts().add(account);


        //save the account and the customer
        accountRepository.save(account);
        customerRepository.save(customer);

        //convert the account to AccountResponse
        AccountResponseDTO accountResponseDTO = modelMapper.map(account, AccountResponseDTO.class);

        return CustomerWithAccounts.builder()
                .customerId(customer.getCustomerId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .telephone(customer.getTelephone())
                .accountResponses(Collections.singletonList(accountResponseDTO))
                .build();

    }


    }


