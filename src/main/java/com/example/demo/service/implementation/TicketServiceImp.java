package com.example.demo.service.implementation;

import com.example.demo.entity.Tickets;
import com.example.demo.mapper.TicketMapper;
import com.example.demo.models.Tickets.CreateTicketInputModel;
import com.example.demo.models.Tickets.TicketGetInputModel;
import com.example.demo.models.Tickets.TicketResponseModel;
import com.example.demo.models.Tickets.UpdateTicketInputModel;
import com.example.demo.repository.TicketRepository;
import com.example.demo.service.TicketService;
import com.example.demo.utils.Enum.EnumStatus;
import com.example.demo.utils.Enum.EnumTicketStatus;
import com.example.demo.utils.Enum.EnumTicketType;
import com.example.demo.utils.Validations.UserValidationService;
import com.example.demo.utils.constants.TicketConstants;
import com.example.demo.utils.constants.userConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TicketServiceImp implements TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    TicketMapper ticketMapper;

    @Autowired
    UserValidationService userValidationService;

    public TicketResponseModel createTask (CreateTicketInputModel createInputData) {

        userValidationService.ticketModuleCommonValidation(createInputData.getTicketName());

        Tickets tickets = ticketMapper.toTicketEntity(createInputData);
        tickets.setStatus(EnumStatus.Active);
        tickets.setCreatedAt(LocalDateTime.now());
        tickets.setUpdatedAt(LocalDateTime.now());
        Tickets createdTicket = ticketRepository.save(tickets);
        return ticketMapper.toTicketResponse(createdTicket);
    }

    public List<TicketResponseModel> getTicketsList (TicketGetInputModel getData) {
        EnumTicketStatus ticketStatus = getData.getTicketStatus() != null ? getData.getTicketStatus() : null;
        EnumTicketType ticketType = getData.getTicketType() != null ? getData.getTicketType() : null;
        String searchText = (getData.getSearchText() != null && !getData.getSearchText().isEmpty()) ? getData.getSearchText() : null;

        List<Tickets> ticket;
        if(ticketStatus!= null && ticketType!=null) {
            ticket = ticketRepository.findByticketStatusandticketType(ticketStatus, ticketType);
        } else if(ticketStatus == null && ticketType!=null) {
            ticket = ticketRepository.findByticketType(ticketType);
        } else if(ticketStatus!= null && ticketType == null) {
            ticket = ticketRepository.findByticketStatus(ticketStatus);
        } else {
            ticket = ticketRepository.findAll();
        }

        return ticket.stream()
                .filter(tickets -> {
                    if(searchText != null) {
                        String lowerSearchText = searchText.toLowerCase();
                        return tickets.getTicketName().contains(lowerSearchText) ||
                                tickets.getTicketDesc().contains(lowerSearchText);
                    }
                    return true;
                })
                .map(ticketMapper::toTicketResponse)
                .collect(Collectors.toList());
    }

    public ResponseEntity<TicketResponseModel> getById (Long id) {
        Optional<Tickets> getData = ticketRepository.findByIdAndStatus(id, EnumStatus.Active);
        if (getData.isPresent()) {
            TicketResponseModel responseData = ticketMapper.toTicketResponse(getData.get());
            return ResponseEntity.ok(responseData);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<String> deleteById (Long id) {
        Optional<Tickets> deleteData = ticketRepository.findByIdAndStatus(id, EnumStatus.Active);
        if (deleteData.isPresent()) {
            Tickets ticket = deleteData.get();
            ticket.setStatus(EnumStatus.Inactive);
            ticketRepository.save(ticket);
            return ResponseEntity.ok(TicketConstants.TICKET_DEACTIVATE_SUCCESS);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(TicketConstants.TICKET_DEACTIVATE_FAIL);
        }
    }

    public ResponseEntity<String> updateTicketById(Long id, UpdateTicketInputModel updateInputData) {
        Optional<Tickets> updateData = ticketRepository.findByIdAndStatus(id, EnumStatus.Active);
        if (updateData.isPresent()) {
            Tickets tickets = updateData.get();
            tickets.setId(id);
            tickets.setTicketName(updateInputData.getTicketName());
            tickets.setTicketDesc(updateInputData.getTicketDesc());
            tickets.setTicketType(updateInputData.getTicketType());
            tickets.setTicketStatus(updateInputData.getTicketStatus());
            tickets.setPrice(updateInputData.getPrice());
            tickets.setUpdatedAt(LocalDateTime.now());
            ticketRepository.save(tickets);
            return ResponseEntity.ok(TicketConstants.TICKET_UPDATE_SUCCESS);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(TicketConstants.TICKET_DEACTIVATE_FAIL);
        }
    }
}
