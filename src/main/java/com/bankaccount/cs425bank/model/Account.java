package com.bankaccount.cs425bank.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
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


    @NotNull
    private String status;

    @NotNull
    private BigDecimal balance;



    @ManyToMany
    @JoinTable(name = "customer_account",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id"))
    private Set<Customer> customers = new HashSet<>();



}
