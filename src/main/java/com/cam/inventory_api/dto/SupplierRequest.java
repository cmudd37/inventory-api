package com.cam.inventory_api.dto;

import jakarta.validation.constraints.NotBlank;

public class SupplierRequest {
    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @NotBlank
    private Integer phoneNumber;

    public SupplierRequest() {}

    public SupplierRequest(String name, String email, Integer phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
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

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
