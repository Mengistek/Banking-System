package com.bankaccount.cs425bank.dto.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountWithCustomerResponse {
    private Long accountId;
    private String accountNumber;
    private LocalDate dateOpened;
    private String status;
    private Double balance;
    private List<CustomerResponseDTO> customerResponses;

}
