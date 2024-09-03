package com.bankaccount.cs425bank.dto.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerWithAccounts {
    private Integer customerId;
    private String firstName;
    private String lastName;
    private String telephone;
    private List<AccountResponseDTO> accountResponses;
}
