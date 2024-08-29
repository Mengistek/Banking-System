package com.bankaccount.cs425bank.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountRequestDto {
    @NotNull
    private String accountNumber;

    @NotNull
    @PastOrPresent
    private LocalDate dateOpened;

    @NotNull
    private String status;

    @NotNull
    @DecimalMin("0.0")
    private BigDecimal balance;

}
