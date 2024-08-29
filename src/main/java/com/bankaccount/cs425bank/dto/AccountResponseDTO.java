package com.bankaccount.cs425bank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponseDTO {

    private Long accountId ;
    private String accountNumber;
    private LocalDate dateOpened;
    private String status;
    private BigDecimal balance;


}
