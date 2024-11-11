package com.example.demo.mapper;

import com.example.demo.entity.user;
import com.example.demo.models.userInputModel;
import com.example.demo.models.userResponseModel;
import com.example.demo.utils.constants.Enum.EnumStatus;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.example.demo.utils.constants.Enum.EnumStatus.Active;

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

    public userInputModel toInputModel(Optional<user> userEntity) {
        if(userEntity.isPresent()) {
            userInputModel inputModel = new userInputModel();
            user entity = userEntity.get();
            inputModel.setName(entity.getName());
            inputModel.setEmail(entity.getEmail());
            inputModel.setMobileNo(entity.getMobileNo());
            inputModel.setLocation(entity.getLocation());
            return inputModel;
        }
        return null;
    }

}
