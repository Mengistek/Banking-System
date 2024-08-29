package com.bankaccount.cs425bank.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private String telephone;

    @ManyToMany(mappedBy = "customers")
    private Set<Account> accounts = new HashSet<>();

}
