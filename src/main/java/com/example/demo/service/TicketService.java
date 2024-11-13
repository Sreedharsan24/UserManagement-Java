package com.example.demo.service;

import com.example.demo.entity.Tickets;
import com.example.demo.entity.user;
import com.example.demo.models.Tickets.CreateTicketInputModel;
import com.example.demo.models.Tickets.TicketGetInputModel;
import com.example.demo.models.Tickets.TicketResponseModel;
import com.example.demo.models.Tickets.UpdateTicketInputModel;
import com.example.demo.utils.Enum.EnumStatus;
import org.springframework.http.ResponseEntity;

import java.nio.file.FileAlreadyExistsException;
import java.util.List;
import java.util.Optional;

public interface TicketService {

    TicketResponseModel createTask (CreateTicketInputModel createInputData) throws FileAlreadyExistsException;

    List<TicketResponseModel> getTicketsList (TicketGetInputModel getData) throws FileAlreadyExistsException;

    ResponseEntity<TicketResponseModel> getById (Long id) throws FileAlreadyExistsException;

    ResponseEntity<String> deleteById (Long id) throws FileAlreadyExistsException;

    ResponseEntity<String> updateTicketById(Long id, UpdateTicketInputModel updateInputData) throws FileAlreadyExistsException;
}
