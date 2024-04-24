package com.example.kzassettwoslices.model;

import jakarta.persistence.*;

@Entity
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long branchId;

    private String address;
    private String number;

    public String getAddress() {
        return address;
    }

    public String getNumber() {
        return number;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
