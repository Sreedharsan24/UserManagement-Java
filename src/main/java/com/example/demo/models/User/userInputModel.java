package com.example.demo.models.User;

import com.example.demo.utils.constants.userConstants;
import jakarta.validation.constraints.*;


public class userInputModel {
    @NotBlank(message = userConstants.NAME_REQUIRED)
    @Size(message = userConstants.NAME_SIZE, min = 4)
    private String name;

    @NotBlank(message = userConstants.EMAIL_REQUIRED)
    @Email(message = userConstants.EMAIL_INVALID)
    private String email;

    @NotBlank(message = userConstants.MOBILE_NO_REQUIRED)
    @Pattern(regexp = "^\\d{10}$" , message = userConstants.MOBILE_NO_SIZE)
    private String mobileNo;

    @NotBlank(message = userConstants.LOCATION_REQUIRED)
    @Size(message = userConstants.LOCATION_SIZE, max = 100)
    private String location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation( String location) {
        this.location = location;
    }
}
