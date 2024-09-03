package com.bankaccount.cs425bank.dto.ResponseDto;

import com.bankaccount.cs425bank.dto.ResponseDto.AccountResponseDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CustomerResponseDTO {
    private Integer customerId;
    private String firstName;
    private String lastName;
    private String telephone;
    private List<AccountResponseDTO> accounts;

}
