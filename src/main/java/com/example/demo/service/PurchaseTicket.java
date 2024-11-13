package com.example.demo.service;

import com.example.demo.models.Transaction.PurchaseTicketInput;
import com.example.demo.models.Transaction.cancelTicketInput;
import org.springframework.http.ResponseEntity;

import java.nio.file.FileAlreadyExistsException;

public interface PurchaseTicket {

    ResponseEntity<String> getTicket(PurchaseTicketInput ticketInput) throws FileAlreadyExistsException;

    ResponseEntity<String> cancelTicket(cancelTicketInput ticketCancelInput) throws FileAlreadyExistsException;

}
