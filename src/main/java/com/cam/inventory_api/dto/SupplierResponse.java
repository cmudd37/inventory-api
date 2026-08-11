package com.cam.inventory_api.dto;

public class SupplierResponse {
    private Long supplierId;
    private String name;
    private String email;
    private String phoneNumber;

    public SupplierResponse() {}

    public SupplierResponse(Long supplierId, String name, String email, String phoneNumber) {
        this.supplierId = supplierId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
