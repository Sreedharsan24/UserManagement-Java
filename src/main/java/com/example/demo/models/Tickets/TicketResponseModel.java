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
    private LocalDateTime ExpireAt;
    private String arrival;
    private String departure;
    private LocalDateTime travelDate;

    public TicketResponseModel(long id, String ticketName, String ticketDesc, EnumTicketType ticketType, EnumTicketStatus ticketStatus, BigDecimal price, EnumStatus status, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime ExpireAt, String arrival, String departure, LocalDateTime travelDate) {
        this.id = id;
        this.ticketName = ticketName;
        this.ticketDesc = ticketDesc;
        this.ticketType = ticketType;
        this.ticketStatus = ticketStatus;
        this.price = price;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.ExpireAt = ExpireAt;
        this.arrival = arrival;
        this.departure = departure;
        this.travelDate = travelDate;
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

    public LocalDateTime getExpireAt() {
        return ExpireAt;
    }

    public void setExpireAt(LocalDateTime expireAt) {
        ExpireAt = expireAt;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public LocalDateTime getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(LocalDateTime travelDate) {
        this.travelDate = travelDate;
    }
}
