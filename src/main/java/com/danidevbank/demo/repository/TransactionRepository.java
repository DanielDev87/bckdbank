package com.danidevbank.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.danidevbank.demo.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("SELECT t FROM Transaction t WHERE t.sourceAccount.id = :accountId OR t.destinationAccount.id = : accountId ORDER BY t.timestamp DESC")
    List<Transaction> findAllByAccountId(@Param("accountId") Long accountId);
}
