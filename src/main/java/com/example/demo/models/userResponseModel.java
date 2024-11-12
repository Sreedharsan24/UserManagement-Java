package com.example.demo.models;

import com.example.demo.utils.Enum.EnumStatus;

public class userResponseModel {

    private Long id;

    private String name;

    private String email;

    private String mobileNo;

    private EnumStatus status;

    private  String location;

    public userResponseModel(Long id, String name, String email, String mobileNo, EnumStatus status, String location) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobileNo = mobileNo;
        this.status = status;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public EnumStatus getStatus() {
        return status;
    }

    public void setStatus(EnumStatus status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
