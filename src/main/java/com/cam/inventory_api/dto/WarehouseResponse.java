package com.cam.inventory_api.dto;

public class WarehouseResponse {

    private Long warehouseId;
    private String name;
    private String location;
    private Integer capacity;

    public WarehouseResponse() {}

    public WarehouseResponse(Long warehouseId, String name, String location, Integer capacity) {
        this.warehouseId = warehouseId;
        this.name = name;
        this.location = location;
        this.capacity = capacity;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
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

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

}
