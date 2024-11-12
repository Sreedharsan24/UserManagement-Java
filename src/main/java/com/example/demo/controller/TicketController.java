package com.example.demo.controller;

import com.example.demo.models.Tickets.CreateTicketInputModel;
import com.example.demo.models.Tickets.TicketResponseModel;
import com.example.demo.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.FileAlreadyExistsException;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping
    public ResponseEntity<TicketResponseModel> createTicket(@Valid @RequestBody CreateTicketInputModel createInputData) throws FileAlreadyExistsException {
        TicketResponseModel responseData = ticketService.createTask(createInputData);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseData);
    }

}
