package com.example.demo.models.Tickets;

import com.example.demo.utils.Enum.EnumTicketType;
import com.example.demo.utils.constants.TicketConstants;
import com.example.demo.utils.constants.userConstants;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CreateTicketInputModel {

    @NotBlank(message = TicketConstants.TICKET_NAME_REQUIRED)
    @Size(message = TicketConstants.TICKET_NAME_SIZE, min = 4)
    private String ticketName;

    @Size(message = TicketConstants.TICKET_DESC_MAX, max = 200)
    private String ticketDesc;

    @NotNull(message = TicketConstants.TICKET_TYPE_REQUIRED)
    private EnumTicketType ticketType;

    @NotNull(message = TicketConstants.TICKET_PRICE_REQUIRED)
    @DecimalMin(value = "0.01", message = TicketConstants.TICKET_PRICE_MIN)
    @DecimalMax(value = "9999.99", message = TicketConstants.TICKET_PRICE_MAX)
    private BigDecimal price;

    @NotNull(message = userConstants.EXPIRE_AT_REQUIRED)
    @FutureOrPresent
    private LocalDateTime expireAt;

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(LocalDateTime expireAt) {
        this.expireAt = expireAt;
    }
}
