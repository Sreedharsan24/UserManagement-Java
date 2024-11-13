package com.example.demo.repository;

import com.example.demo.entity.Tickets;
import com.example.demo.utils.Enum.EnumStatus;
import com.example.demo.utils.Enum.EnumTicketStatus;
import com.example.demo.utils.Enum.EnumTicketType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface TicketRepository extends JpaRepository<Tickets, Long> {
    List<Tickets> findByTicketStatusAndTicketType(EnumTicketStatus ticketStatus, EnumTicketType ticketType);

    List<Tickets> findByTicketStatus(EnumTicketStatus ticketStatus);

    List<Tickets> findByTicketType(EnumTicketType ticketType);

    Optional<Tickets> findByIdAndStatus(Long id, EnumStatus status);

    boolean existsByTicketName(String ticketName);

    boolean existsByIdAndTicketStatusAndTicketType(Long id, EnumTicketStatus ticketStatus, EnumTicketType ticketType);



}
