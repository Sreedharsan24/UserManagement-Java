package com.example.demo.models.Tickets;

import com.example.demo.utils.Enum.EnumTicketStatus;
import com.example.demo.utils.Enum.EnumTicketType;
import com.example.demo.utils.constants.TicketConstants;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class UpdateTicketInputModel {
    @NotBlank(message = TicketConstants.TICKET_NAME_REQUIRED)
    @Size(message = TicketConstants.TICKET_NAME_SIZE, min = 4)
    private String ticketName;

    @Size(message = TicketConstants.TICKET_DESC_MAX, max = 200)
    private String ticketDesc;

    @NotBlank(message = TicketConstants.TICKET_TYPE_REQUIRED)
    @Pattern(regexp = "^(ONLINE|OFFLINE)$", message = TicketConstants.TICKET_TYPE)
    private EnumTicketType ticketType;

    @NotBlank(message = TicketConstants.TICKET_STATUS_REQUIRED)
    @Pattern(regexp = "^(Avaliable|Sold)$", message = TicketConstants.TICKET_STATUS)
    private EnumTicketStatus ticketStatus;

    @NotBlank(message = TicketConstants.TICKET_PRICE_REQUIRED)
    @DecimalMin(value = "0.01", message = TicketConstants.TICKET_PRICE_MIN)
    @DecimalMax(value = "9999.99", message = TicketConstants.TICKET_PRICE_MAX)
    private BigDecimal price;

    public  String getTicketName() {
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
}
