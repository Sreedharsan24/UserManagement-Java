package com.example.demo.service.implementation;

import com.example.demo.entity.Tickets;
import com.example.demo.mapper.TicketMapper;
import com.example.demo.models.Tickets.CreateTicketInputModel;
import com.example.demo.models.Tickets.TicketResponseModel;
import com.example.demo.repository.TicketRepository;
import com.example.demo.service.TicketService;
import com.example.demo.utils.Enum.EnumStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TicketServiceImp implements TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    TicketMapper ticketMapper;

    public TicketResponseModel createTask (CreateTicketInputModel createInputData) {
        Tickets tickets = ticketMapper.toTicketEntity(createInputData);
        tickets.setStatus(EnumStatus.Active);
        tickets.setCreatedAt(LocalDateTime.now());
        tickets.setUpdatedAt(LocalDateTime.now());
        Tickets createdTicket = ticketRepository.save(tickets);
        return ticketMapper.toTicketResponse(createdTicket);
    }


}
