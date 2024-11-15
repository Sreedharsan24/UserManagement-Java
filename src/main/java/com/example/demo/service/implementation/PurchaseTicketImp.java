package com.example.demo.service.implementation;

import com.example.demo.email.EmailService;
import com.example.demo.entity.Tickets;
import com.example.demo.entity.Transaction;
import com.example.demo.exceptions.FieldValidationException;
import com.example.demo.mapper.PurchaseTicketMapper;
import com.example.demo.models.Transaction.PurchaseTicketInput;
import com.example.demo.models.Transaction.cancelTicketInput;
import com.example.demo.repository.PurchaseTicketRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.service.PurchaseTicket;
import com.example.demo.utils.Enum.EnumStatus;
import com.example.demo.utils.Enum.EnumTicketStatus;
import com.example.demo.utils.Enum.EnumTicketType;
import com.example.demo.utils.Validations.UserValidationService;
import com.example.demo.utils.constants.TicketConstants;
import com.example.demo.utils.constants.TransactionConstants;
import com.example.demo.utils.constants.userConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PurchaseTicketImp implements PurchaseTicket {

    @Autowired
    private PurchaseTicketRepository purchaseTicketRepository;

    @Autowired
    UserValidationService userValidationService;

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    EmailService emailService;

    @Autowired
    PurchaseTicketMapper purchaseTicketMapper;

    public ResponseEntity<String> getTicket(PurchaseTicketInput ticketInput) {
        userValidationService.userIDExistValidation(ticketInput.getUser_id());
        userValidationService.ticketIDExistValidation(ticketInput.getTicket_id());

        if (!(ticketInput.getPurchaseType() == EnumTicketType.Online || ticketInput.getPurchaseType() == EnumTicketType.Offline)) {
            throw new FieldValidationException("Error", TicketConstants.TICKET_TYPE);
        }

        if (!ticketRepository.existsByIdAndTicketStatusAndTicketType(Long.parseLong(ticketInput.getTicket_id()), EnumTicketStatus.Avaliable, ticketInput.getPurchaseType())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(TransactionConstants.TICKET_ALREADY_SOLD);
        }

        try{
            Transaction transaction = purchaseTicketMapper.toEntity(ticketInput);
            transaction.setCreatedAt(LocalDateTime.now());
            transaction.setUpdatedAt(LocalDateTime.now());
            purchaseTicketRepository.save(transaction);

            emailService.sendBookConfirmationEmail("Sreedharsanpk@gmail.com", ticketInput.getTicket_id(), "Ticket Description for the Ticket Booking Management System");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Tickets ticket = ticketRepository.findById(Long.parseLong(ticketInput.getTicket_id()))
                .orElseThrow(() -> new IllegalArgumentException("Ticket not found with ID: " + ticketInput.getTicket_id()));

        if(ticket.getStatus() == EnumStatus.Inactive) {
            throw new FieldValidationException("Error", userConstants.TICKET_INACTIVE);
        }

        ticket.setTicketStatus(EnumTicketStatus.Sold);
        try{
            ticketRepository.save(ticket);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(TransactionConstants.TICKET_BOOKED);
    }

    public ResponseEntity<String> cancelTicket(cancelTicketInput ticketCancelInput) {
        userValidationService.userIDExistValidation(ticketCancelInput.getUser_id());
        userValidationService.ticketIDExistValidation(ticketCancelInput.getTicket_id());

        Tickets cancelTicket = ticketRepository.findById(Long.parseLong(ticketCancelInput.getTicket_id()))
                .orElseThrow(() -> new IllegalArgumentException("Ticket not found with ID: " + ticketCancelInput.getTicket_id()));

        Transaction transactionTicket = purchaseTicketRepository.findLastTransactionByTicketIdNative(Long.parseLong(ticketCancelInput.getTicket_id()));
        System.out.println(transactionTicket.getUser().getId());
        System.out.println(ticketCancelInput.getUser_id());

        if(transactionTicket.getUser().getId() != Long.parseLong(ticketCancelInput.getUser_id())){
            throw new FieldValidationException("Error", userConstants.TICKET_USER_INVALID);
        }

        if (!cancelTicket.getExpireDate().isBefore(LocalDateTime.now()) && cancelTicket.getTicketStatus() == EnumTicketStatus.Sold) {
            cancelTicket.setTicketStatus(EnumTicketStatus.Avaliable);
            ticketRepository.save(cancelTicket);
            return ResponseEntity.status(HttpStatus.OK).body(TransactionConstants.TICKET_CANCELLED);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(TransactionConstants.TICKET_EXPIRED);
        }
    }
}
