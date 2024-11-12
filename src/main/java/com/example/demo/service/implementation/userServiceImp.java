package com.example.demo.service.implementation;

import com.example.demo.mapper.userMapper;
import com.example.demo.models.User.UserGetInputModel;
import com.example.demo.models.User.userInputModel;
import com.example.demo.models.User.userResponseModel;
import com.example.demo.repository.userRepository;
import com.example.demo.service.userService;
import com.example.demo.utils.Enum.EnumStatus;
import com.example.demo.utils.Validations.UserValidationService;
import com.example.demo.utils.constants.userConstants;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.entity.user;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class userServiceImp implements userService {

    @Autowired
    userRepository userRepository;

    @Autowired
    userMapper userMapper;

    @Autowired
    UserValidationService userValidationService;



    public userResponseModel create(userInputModel userData) {

        userValidationService.userModuleCommonValidation(userData.getEmail(), userData.getMobileNo());

        user userEntity = userMapper.toEntity(userData);
        user createdUser = userRepository.save(userEntity);
        return userMapper.toResponseModel(createdUser);
    }

    public List<userResponseModel> getAllUsers(UserGetInputModel getData) {
        EnumStatus status = getData.getStatus() != null ? getData.getStatus() : null;
        String location = (getData.getLocation() != null && !getData.getLocation().isEmpty()) ? getData.getLocation() : null;
        String searchText = (getData.getSearchText() != null && !getData.getSearchText().isEmpty()) ? getData.getSearchText() : null;

        List<user> users;
        if (status != null && location != null) {
            users = userRepository.findByStatusAndLocation(status, location);
        } else if (status != null) {
            users = userRepository.findByStatus(status);
        } else if (location != null) {
            users = userRepository.findByLocation(location);
        } else {
            users = userRepository.findAll();
        }

        return users.stream()
                .filter(user -> {
                    if(searchText != null) {
                        String lowerSearchText = searchText.toLowerCase();
                        return user.getName().toLowerCase().contains(lowerSearchText) ||
                                user.getEmail().toLowerCase().contains(lowerSearchText) ||
                                user.getMobileNo().toLowerCase().contains(lowerSearchText) ||
                                user.getLocation().toLowerCase().contains(lowerSearchText);
                    }
                    return true;
                })
                .map(userMapper::toResponseModel)
                .collect(Collectors.toList());
    }

    public ResponseEntity<userResponseModel> getUserById(Long id) {
        Optional<user> userEntity = userRepository.findByIdAndStatus(id, EnumStatus.Active);
        if (userEntity.isPresent()) {
            userResponseModel responseModel = userMapper.toResponseModel(userEntity.get());
            return ResponseEntity.ok(responseModel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<String> deleteById(Long Id) {
        Optional<user> userOptional = userRepository.findById(Id);
        if (userOptional.isPresent()) {
            user userEntity = userOptional.get();
            userEntity.setStatus(EnumStatus.Inactive);
            userRepository.save(userEntity);
            return ResponseEntity.ok(userConstants.USER_DEACTIVATE_SUCCESS);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(userConstants.USER_DEACTIVATE_FAIL);
        }
    }

    public userResponseModel updateUser(Long id, userInputModel updateData) {
        Optional <user> updateUser = userRepository.findById(id);

        if (updateUser.isPresent()) {
            userValidationService.userModuleCommonValidation(updateData.getEmail(), updateData.getMobileNo());
            user userEntity = userMapper.toEntity(updateData);
            userEntity.setId(id);
            user updatedData = userRepository.save(userEntity);
            return userMapper.toResponseModel(updatedData);
        } else {
            return null;
        }
    }
}
