package com.example.demo.models.Transaction;

import com.example.demo.utils.Enum.EnumTicketType;
import com.example.demo.utils.constants.TransactionConstants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class PurchaseTicketInput {

    @NotEmpty(message = TransactionConstants.USERID_REQUIRED)
    private String user_id;

    @NotEmpty(message = TransactionConstants.TICKETID_REQUIRED)
    private String ticket_id;

    @NotNull(message = TransactionConstants.PURCHASE_TYPE_REQUIRED)
    private EnumTicketType purchaseType;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(String ticket_id) {
        this.ticket_id = ticket_id;
    }

    public EnumTicketType getPurchaseType() {
        return purchaseType;
    }

    public void setPurchaseType(EnumTicketType purchaseType) {
        this.purchaseType = purchaseType;
    }
}
