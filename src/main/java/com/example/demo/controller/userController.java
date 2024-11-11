package com.example.demo.controller;

import com.example.demo.models.UserGetInputModel;
import com.example.demo.models.userInputModel;
import com.example.demo.models.userResponseModel;
import com.example.demo.service.implementation.userService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.user;

import java.nio.file.FileAlreadyExistsException;
import java.util.List;

@RestController
@RequestMapping("/users")
public class userController {

    @Autowired
    private userService UserService;

    @PostMapping
    public ResponseEntity<userResponseModel> createUser(@Valid @RequestBody userInputModel User) throws FileAlreadyExistsException {
        userResponseModel createdUser = UserService.create(User);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PostMapping("/get")
    public List<userResponseModel> getAllList(@Valid @RequestBody UserGetInputModel getData) throws FileAlreadyExistsException {
        return UserService.getAllUsers(getData);
    }

    @GetMapping("{id}")
    public ResponseEntity<userResponseModel> getUserById(@PathVariable Long id) {
        return UserService.getUserById(id);
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        return UserService.deleteById(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<userResponseModel> updateUser(@PathVariable Long id, @Valid @RequestBody userInputModel updateData) {
        userResponseModel updatedUser = UserService.updateUser(id, updateData);
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedUser);
    }
}