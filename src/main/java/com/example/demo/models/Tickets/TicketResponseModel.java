package com.example.demo.models.Tickets;

import com.example.demo.utils.Enum.EnumStatus;
import com.example.demo.utils.Enum.EnumTicketStatus;
import com.example.demo.utils.Enum.EnumTicketType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TicketResponseModel {
    private long id;
    private String ticketName;
    private String ticketDesc;
    private EnumTicketType ticketType;
    private EnumTicketStatus ticketStatus;
    private BigDecimal price;
    private EnumStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public TicketResponseModel(long id, String ticketName, String ticketDesc, EnumTicketType ticketType, EnumTicketStatus ticketStatus, BigDecimal price, EnumStatus status, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.ticketName = ticketName;
        this.ticketDesc = ticketDesc;
        this.ticketType = ticketType;
        this.ticketStatus = ticketStatus;
        this.price = price;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

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
