package com.example.demo.controller;

import com.example.demo.models.Tickets.CreateTicketInputModel;
import com.example.demo.models.Tickets.TicketGetInputModel;
import com.example.demo.models.Tickets.TicketResponseModel;
import com.example.demo.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.FileAlreadyExistsException;
import java.util.List;
import java.util.Optional;

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

    @PostMapping("/get")
    public List<TicketResponseModel> getTicketsList(@Valid @RequestBody TicketGetInputModel getData) {
        return ticketService.getTicketsList(getData);
    }

    @GetMapping("/id")
    public ResponseEntity<TicketResponseModel> getTicketById(Long id) {
        return ticketService.getById(id);
    }

    @PutMapping("/id")
    public ResponseEntity<String> deleteTicket(Long id) {
        return ticketService.deleteById(id);
    }
}
