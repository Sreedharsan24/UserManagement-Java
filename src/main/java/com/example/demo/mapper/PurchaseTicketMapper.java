package com.example.demo.mapper;

import com.example.demo.entity.Tickets;
import com.example.demo.entity.Transaction;
import com.example.demo.models.Transaction.PurchaseTicketInput;
import com.example.demo.repository.TicketRepository;
import com.example.demo.repository.userRepository;
import com.example.demo.utils.Enum.EnumStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PurchaseTicketMapper {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private userRepository userRepository;

    public Transaction toEntity(PurchaseTicketInput ticketInput) {
        Transaction transaction = new Transaction();
        transaction.setTicket(ticketRepository.findById(Long.parseLong(ticketInput.getTicket_id()))
                .orElseThrow(() -> new IllegalArgumentException("Ticket not found with ID: " + ticketInput.getTicket_id())));
        transaction.setUser(userRepository.findById(Long.parseLong(ticketInput.getUser_id()))
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + ticketInput.getUser_id())));
        transaction.setStatus(EnumStatus.Active);
        return transaction;
    }
}
