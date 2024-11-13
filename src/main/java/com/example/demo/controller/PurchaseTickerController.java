package com.example.demo.controller;

import com.example.demo.models.Transaction.PurchaseTicketInput;
import com.example.demo.models.Transaction.cancelTicketInput;
import com.example.demo.service.PurchaseTicket;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.nio.file.FileAlreadyExistsException;

@RestController
@RequestMapping("/purchase")
public class PurchaseTickerController {

    @Autowired
    private PurchaseTicket purchaseTicket;

    @PostMapping("/purchaseTicket")
    public ResponseEntity<String> purchaseTicket(@Valid @RequestBody PurchaseTicketInput ticketInput) throws FileAlreadyExistsException {
        return purchaseTicket.getTicket(ticketInput);
    }

    @PostMapping("/cancelTicket")
    public ResponseEntity<String> cancelTicket(@Valid @RequestBody cancelTicketInput ticketCancelInput) throws FileAlreadyExistsException {
        return purchaseTicket.cancelTicket(ticketCancelInput);
    }
}
