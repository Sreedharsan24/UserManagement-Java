package com.example.demo.repository;

import com.example.demo.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

public interface PurchaseTicketRepository extends JpaRepository<Transaction, Long> {

    @Query(value = "SELECT * FROM transaction WHERE ticket_id = :ticketId ORDER BY created_at DESC LIMIT 1", nativeQuery = true)
    Transaction findLastTransactionByTicketIdNative(@Param("ticketId") Long ticketId);

}
