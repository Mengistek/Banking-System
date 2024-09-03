package com.bankaccount.cs425bank.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId ;

    @NotNull
    @Column(unique = true)
    private String accountNumber;

    @Temporal(TemporalType.DATE)
    @NotNull
    private LocalDate dateOpened;


    @NotBlank(message = "Status can not be empty")
    private String status;

    @Column(nullable = false)
    private BigDecimal balance;

    @NotNull
    private String accountType;

    @ManyToMany(mappedBy = "accounts", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Customer> customers = new ArrayList<>();



}
