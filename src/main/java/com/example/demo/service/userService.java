package com.example.demo.service;

import com.example.demo.models.UserGetInputModel;
import com.example.demo.models.userInputModel;
import com.example.demo.models.userResponseModel;
import org.springframework.http.ResponseEntity;
import java.nio.file.FileAlreadyExistsException;
import java.util.List;

public interface userService {

    userResponseModel create(userInputModel userData) throws FileAlreadyExistsException;

    List<userResponseModel> getAllUsers(UserGetInputModel getData) throws FileAlreadyExistsException;

    ResponseEntity<userResponseModel> getUserById(Long id);

    ResponseEntity<String> deleteById(Long Id);

    userResponseModel updateUser(Long id, userInputModel updateData);
}
