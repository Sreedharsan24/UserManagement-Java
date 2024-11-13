package com.example.demo.models.Transaction;

import com.example.demo.utils.constants.TransactionConstants;
import jakarta.validation.constraints.NotBlank;

public class cancelTicketInput {

    @NotBlank(message = TransactionConstants.USERID_REQUIRED)
    private String user_id;

    @NotBlank(message = TransactionConstants.TICKETID_REQUIRED)
    private String Ticket_id;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getTicket_id() {
        return Ticket_id;
    }

    public void setTicket_id(String ticket_id) {
        Ticket_id = ticket_id;
    }
}
