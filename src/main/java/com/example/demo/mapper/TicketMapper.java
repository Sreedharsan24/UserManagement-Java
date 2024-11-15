package com.example.demo.mapper;

import com.example.demo.entity.Tickets;
import com.example.demo.models.Tickets.CreateTicketInputModel;
import com.example.demo.models.Tickets.TicketResponseModel;
import com.example.demo.models.Tickets.UpdateTicketInputModel;
import com.example.demo.utils.Enum.EnumStatus;
import com.example.demo.utils.Enum.EnumTicketStatus;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {
    public Tickets toTicketEntity(CreateTicketInputModel createInputData) {
        Tickets ticket = new Tickets();
        ticket.setTicketName(createInputData.getTicketName());
        ticket.setTicketDesc(createInputData.getTicketDesc());
        ticket.setTicketType(createInputData.getTicketType());
        ticket.setTicketStatus(EnumTicketStatus.Avaliable);
        ticket.setExpireDate(createInputData.getExpireAt());
        ticket.setPrice(createInputData.getPrice());
        ticket.setArrival(createInputData.getArrival());
        ticket.setDeparture(createInputData.getDeparture());
        ticket.setTravelDate(createInputData.getTravelDate());
        return ticket;
    };

    public TicketResponseModel toTicketResponse(Tickets ticket) {
        return new TicketResponseModel(
                ticket.getId(),
                ticket.getTicketName(),
                ticket.getTicketDesc(),
                ticket.getTicketType(),
                ticket.getTicketStatus(),
                ticket.getPrice(),
                ticket.getStatus(),
                ticket.getCreatedAt(),
                ticket.getUpdatedAt(),
                ticket.getExpireDate(),
                ticket.getArrival(),
                ticket.getDeparture(),
                ticket.getTravelDate()
        );
    }

    public Tickets toEntityForUpdate(UpdateTicketInputModel updateInputData) {
        Tickets tickets = new Tickets();
        tickets.setTicketName(updateInputData.getTicketName());
        tickets.setTicketDesc(updateInputData.getTicketDesc());
        tickets.setTicketType(updateInputData.getTicketType());
        tickets.setTicketStatus(updateInputData.getTicketStatus());
        tickets.setPrice(updateInputData.getPrice());
        tickets.setArrival(updateInputData.getArrival());
        tickets.setDeparture(updateInputData.getDeparture());
        tickets.setTravelDate(updateInputData.getTravelDate());
        tickets.setStatus(updateInputData.getStatus());
        tickets.setExpireDate(updateInputData.getExpireAt());
        return tickets;
    }
}
