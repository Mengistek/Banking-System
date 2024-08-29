package com.bankaccount.cs425bank.repository;

import com.bankaccount.cs425bank.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query("SELECT a FROM Account a where a.dateOpened < :date AND a.status = :status")
    List<Account> findByDateOpenedBeforeAndStatus(LocalDate date, String status);
}
