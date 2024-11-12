package com.example.demo.service;

import com.example.demo.models.Tickets.CreateTicketInputModel;
import com.example.demo.models.Tickets.TicketResponseModel;
import java.nio.file.FileAlreadyExistsException;

public interface TicketService {

    TicketResponseModel createTask (CreateTicketInputModel createInputData) throws FileAlreadyExistsException;
}
