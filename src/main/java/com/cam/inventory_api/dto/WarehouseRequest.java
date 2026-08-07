package com.cam.inventory_api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class WarehouseRequest {
    @NotBlank
    private String name;

    @NotBlank
    private String address;

    @NotBlank
    private String location;

    @Min(0)
    private Integer capacity;

    public WarehouseRequest() {}

    public WarehouseRequest(String name, String address, String location, Integer capacity) {
        this.name = name;
        this.address = address;
        this.location = location;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
