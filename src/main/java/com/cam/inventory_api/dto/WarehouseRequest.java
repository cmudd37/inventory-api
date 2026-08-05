package com.cam.inventory_api.dto;

import jakarta.validation.constraints.NotBlank;

public class WarehouseRequest {
    @NotBlank
    private String name;

    @NotBlank
    private String location;

    public WarehouseRequest() {}

    public WarehouseRequest(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
