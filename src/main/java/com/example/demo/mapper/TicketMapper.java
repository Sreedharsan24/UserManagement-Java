package com.example.demo.mapper;

import com.example.demo.entity.Tickets;
import com.example.demo.models.Tickets.CreateTicketInputModel;
import com.example.demo.models.Tickets.TicketResponseModel;
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
        ticket.setPrice(createInputData.getPrice());
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
                ticket.getUpdatedAt()
        );
    }
}
