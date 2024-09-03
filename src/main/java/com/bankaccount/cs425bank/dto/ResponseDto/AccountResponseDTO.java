package com.bankaccount.cs425bank.dto.ResponseDto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AccountResponseDTO {

    private Long accountId ;
    private String accountNumber;
    private LocalDate dateOpened;
    private String status;
    private BigDecimal balance;
    private String accountType;



}
