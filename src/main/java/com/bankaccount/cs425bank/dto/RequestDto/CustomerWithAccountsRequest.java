package com.bankaccount.cs425bank.dto.RequestDto;

import com.bankaccount.cs425bank.dto.ResponseDto.AccountResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerWithAccountsRequest {
    private Integer customerId;
    private String firstName;
    private String lastName;
    private String telephone;
    private List<AccountResponseDTO> accountResponses;
}
