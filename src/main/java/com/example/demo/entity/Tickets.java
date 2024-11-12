package com.example.demo.entity;

import com.example.demo.utils.Enum.EnumStatus;
import com.example.demo.utils.Enum.EnumTicketStatus;
import com.example.demo.utils.Enum.EnumTicketType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Tickets")
public class Tickets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "Ticket_Name", nullable = false, length = 50)
    private String ticketName;

    @Column(name = "Ticket_Desc", length = 200)
    private String ticketDesc;

    @Enumerated(EnumType.STRING)
    @Column(name = "Ticket_type", nullable = false, length = 50)
    private EnumTicketType ticketType;

    @Enumerated(EnumType.STRING)
    @Column(name = "Ticket_Status", nullable = false, length = 20)
    private EnumTicketStatus ticketStatus;

    @Column(name = "Price", nullable = false, precision = 15, scale = 2)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status", nullable = false, length = 20)
    private EnumStatus status;

    @Column(name = "Created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "Updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public String getTicketDesc() {
        return ticketDesc;
    }

    public void setTicketDesc(String ticketDesc) {
        this.ticketDesc = ticketDesc;
    }

    public EnumTicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(EnumTicketType ticketType) {
        this.ticketType = ticketType;
    }

    public EnumTicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(EnumTicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public EnumStatus getStatus() {
        return status;
    }

    public void setStatus(EnumStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}