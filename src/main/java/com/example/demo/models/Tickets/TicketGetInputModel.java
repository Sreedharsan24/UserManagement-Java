package com.example.demo.models.Tickets;

import com.example.demo.utils.Enum.EnumTicketStatus;
import com.example.demo.utils.Enum.EnumTicketType;
import com.example.demo.utils.constants.TicketConstants;
import com.example.demo.utils.constants.userConstants;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class TicketGetInputModel {
    @Size(max = 100, message = userConstants.SEARCH_MAX_LIMIT)
    private String searchText;

    @Pattern(regexp = "^(Online|Offline)$", message = TicketConstants.TICKET_TYPE)
    private EnumTicketType ticketType;


    @Pattern(regexp = "^(Avaliable|Sold)$", message = TicketConstants.TICKET_STATUS)
    private EnumTicketStatus ticketStatus;

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
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
}
