package com.example.demo.models;

import com.example.demo.utils.Enum.EnumStatus;
import com.example.demo.utils.constants.userConstants;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Size;

public class UserGetInputModel {
    @Size(max = 100, message = userConstants.SEARCH_MAX_LIMIT)
    private String searchText;

    @Size(message = userConstants.LOCATION_SIZE, max = 100)
    private String location;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(255) default 'Active'")
    private EnumStatus status;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public EnumStatus getStatus() {
        return status;
    }

    public void setStatus(EnumStatus status) {
        this.status = status;
    }
}
