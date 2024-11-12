package com.example.demo.mapper;

import com.example.demo.entity.user;
import com.example.demo.models.User.userInputModel;
import com.example.demo.models.User.userResponseModel;
import com.example.demo.utils.Enum.EnumStatus;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class userMapper {

    public user toEntity(userInputModel inputModel) {
        user user = new user();
        user.setName(inputModel.getName());
        user.setEmail(inputModel.getEmail());
        user.setMobileNo(inputModel.getMobileNo());
        user.setStatus(EnumStatus.Active);
        user.setLocation(inputModel.getLocation());
        return user;
    }

    public userResponseModel toResponseModel(user user) {
        return new userResponseModel(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getMobileNo(),
                user.getStatus(),
                user.getLocation()
        );
    }
}
