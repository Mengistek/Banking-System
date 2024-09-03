package com.bankaccount.cs425bank.service;

import com.bankaccount.cs425bank.dto.RequestDto.CustomerRequestDTO;
import com.bankaccount.cs425bank.dto.ResponseDto.AccountResponseDTO;
import com.bankaccount.cs425bank.dto.ResponseDto.CustomerResponseDTO;
import com.bankaccount.cs425bank.dto.ResponseDto.CustomerWithAccounts;
import com.bankaccount.cs425bank.exception.CustomerNotFoundException;
import com.bankaccount.cs425bank.model.Customer;
import com.bankaccount.cs425bank.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor


public class CustomerServiceImp implements CustomerService{

    private final CustomerRepository customerRepository;

    private final ModelMapper modelMapper;

    @Override
    public CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequest) {

        Customer customer = Customer.builder()
                .customerId(null)
                .firstName(customerRequest.getFirstName())
                .lastName(customerRequest.getLastName())
                .telephone(customerRequest.getTelephone())
                .build();
        Customer savedCustomer = customerRepository.save(customer);

        return modelMapper.map(savedCustomer, CustomerResponseDTO.class);

    }

    @Override
    public CustomerWithAccounts getCustomerById(Integer id) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));

        //mapping customer entity to CustomerWithAccountsRequest DTO
        CustomerWithAccounts customerWithAccounts = modelMapper.map(customer, CustomerWithAccounts.class);

        //mapping accounts to AccountResponseDTOs
        List<AccountResponseDTO> accountResponses = customer.getAccounts()
                .stream()
                .map( account -> modelMapper.map(account, AccountResponseDTO.class))
                .collect(Collectors.toList());

        customerWithAccounts.setAccountResponses(accountResponses);

        return customerWithAccounts;
    }
}
