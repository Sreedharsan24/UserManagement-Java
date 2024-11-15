package com.example.demo.utils.Validations;

import com.example.demo.exceptions.FieldValidationException;
import com.example.demo.models.Tickets.CreateTicketInputModel;
import com.example.demo.repository.TicketRepository;
import com.example.demo.repository.userRepository;
import com.example.demo.utils.Enum.EnumTicketType;
import com.example.demo.utils.constants.TicketConstants;
import com.example.demo.utils.constants.userConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserValidationService  {

    @Autowired
    private userRepository userRepository;

    @Autowired
    private TicketRepository ticketRepository;

    public void userModuleCommonValidation (String email, String mobileNo) {
        if (userRepository.existsByEmail(email)) {
            throw new FieldValidationException("Error", userConstants.EMAIL_ALREADY_EXISTS);
        }
        if (userRepository.existsByMobileNo(mobileNo)) {
            throw new FieldValidationException("Error", userConstants.MOBILE_ALREADY_EXISTS);
        }
    }

    public void emailCheck(String email) {
        if (userRepository.existsByEmail(email)) {
            throw new FieldValidationException("Error", userConstants.EMAIL_ALREADY_EXISTS);
        }
    }

    public void mobileCheck(String mobileNo) {
        if (userRepository.existsByMobileNo(mobileNo)) {
            throw new FieldValidationException("Error", userConstants.MOBILE_ALREADY_EXISTS);
        }
    }

    public void ticketModuleCommonValidation(String ticketName) {
        if (ticketRepository.existsByTicketName(ticketName)) {
            throw new FieldValidationException("Error", TicketConstants.TICKET_NAME_ALREADY_EXISTS);
        }
    }

    public void ticketTypeEnumCheck(CreateTicketInputModel createInputData){
        if(!EnumTicketType.Online.equals(createInputData.getTicketType()) || !EnumTicketType.Offline.equals(createInputData.getTicketType())){
            throw new FieldValidationException("Error", TicketConstants.TICKET_TYPE);
        }
    }

    public void userIDExistValidation(String Id) {
        if (!userRepository.existsById(Long.parseLong(Id))) {
            throw new FieldValidationException("Error", userConstants.USER_NOT_FOUND);
        }
    }

    public void ticketIDExistValidation(String Id) {
        if (!ticketRepository.existsById(Long.parseLong(Id))) {
            throw new FieldValidationException("Error", TicketConstants.TICKET_NOT_FOUND);
        }
    }
}
