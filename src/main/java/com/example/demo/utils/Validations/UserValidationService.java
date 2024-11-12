package com.example.demo.utils.Validations;

import com.example.demo.exceptions.FieldValidationException;
import com.example.demo.repository.userRepository;
import com.example.demo.utils.constants.userConstants;
import org.springframework.stereotype.Service;

@Service
public class UserValidationService  {

    private final userRepository userRepository;

    public UserValidationService (userRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void userModuleCommonValidation (String email, String mobileNo) {
        if (userRepository.existsByEmail(email)) {
            throw new FieldValidationException("Email", userConstants.EMAIL_ALREADY_EXISTS);
        }
        if (userRepository.existsByMobileNo(mobileNo)) {
            throw new FieldValidationException("MobileNo", userConstants.MOBILE_ALREADY_EXISTS);
        }
    }
}
