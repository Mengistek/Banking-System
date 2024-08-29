package com.bankaccount.cs425bank.service;

import com.bankaccount.cs425bank.dto.AccountRequestDto;
import com.bankaccount.cs425bank.dto.AccountResponseDTO;
import com.bankaccount.cs425bank.dto.CustomerRequestDTO;
import com.bankaccount.cs425bank.dto.CustomerResponseDTO;
import com.bankaccount.cs425bank.exception.CustomerNotFoundException;
import com.bankaccount.cs425bank.model.Account;
import com.bankaccount.cs425bank.model.Customer;
import com.bankaccount.cs425bank.repository.AccountRepository;
import com.bankaccount.cs425bank.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountService implements AccountServiceImp{
    @Autowired
    private  CustomerRepository customerRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public List<AccountResponseDTO> getPlatinumAccounts() {
            LocalDate fiveYearsAgo= LocalDate.now().minusYears(5);
            return accountRepository.findByDateOpenedBeforeAndStatus(fiveYearsAgo,"Active")
                .stream().map(account -> modelMapper.map(account,AccountResponseDTO.class))
                .sorted(Comparator.comparing(AccountResponseDTO::getBalance).reversed())
                .collect(Collectors.toList());
    }
    @Override
    public CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequestDTO){
            Customer customer = modelMapper.map(customerRequestDTO,Customer.class);

            customer = customerRepository.save(customer);
            return modelMapper.map(customer,CustomerResponseDTO.class);
    }
    @Override
    public CustomerResponseDTO getCustomerById(Integer customerId){
          Customer customer = customerRepository.findById(customerId)
                  .orElseThrow(()-> new CustomerNotFoundException( customerId)) ;
          return  modelMapper.map(customer,CustomerResponseDTO.class);
    }

    public AccountResponseDTO createAccountForCustomer(Integer customerId, AccountRequestDto accountRequestDto) {
            Customer customer = customerRepository.findById(customerId)
                    .orElseThrow(() -> new CustomerNotFoundException(customerId));

        Account account = modelMapper.map(accountRequestDto,Account.class);

        if (account.getCustomers() == null){
            account.setCustomers(new HashSet<>());
        }

        account.getCustomers().add(customer);
        account = accountRepository.save(account);

        return modelMapper.map(account,AccountResponseDTO.class);
    }
}
