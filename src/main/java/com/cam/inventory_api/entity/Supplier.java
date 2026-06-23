package com.cam.inventory_api.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    private String email;
    private Integer phoneNumber;

    @OneToMany(mappedBy = "supplier")
    private List<Product> products;

    public Supplier() {}

    public Supplier(Long id, String companyName, String email, Integer phoneNumber) {
        this.id = id;
        this.companyName = companyName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

