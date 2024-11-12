package com.example.demo.service;

import com.example.demo.entity.Tickets;
import com.example.demo.entity.user;
import com.example.demo.models.Tickets.CreateTicketInputModel;
import com.example.demo.models.Tickets.TicketGetInputModel;
import com.example.demo.models.Tickets.TicketResponseModel;
import com.example.demo.utils.Enum.EnumStatus;
import org.springframework.http.ResponseEntity;

import java.nio.file.FileAlreadyExistsException;
import java.util.List;
import java.util.Optional;

public interface TicketService {

    TicketResponseModel createTask (CreateTicketInputModel createInputData) throws FileAlreadyExistsException;

    List<TicketResponseModel> getTicketsList (TicketGetInputModel getData);

    ResponseEntity<TicketResponseModel> getById (Long id);

    ResponseEntity<String> deleteById (Long id);
}
