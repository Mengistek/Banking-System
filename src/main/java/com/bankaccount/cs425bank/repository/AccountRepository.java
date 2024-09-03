package com.bankaccount.cs425bank.repository;

import com.bankaccount.cs425bank.dto.ResponseDto.AccountWithCustomerResponse;
import com.bankaccount.cs425bank.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query("SELECT a FROM Account a JOIN FETCH a.customers c WHERE YEAR(CURRENT_DATE) - YEAR(a.dateOpened) >= :year AND a.status = :active ORDER BY a.balance DESC")
    List<Account> findAllAccountsDateCreatedGreaterThanFiveYearsAndActive(@Param("year") int year, @Param("active") String active);
}
