package com.example.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "premium_details")

public class PremiumDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String planName;
    private Double amount;
    private Date startDate;
    private Date expiryDate;

    @ManyToOne   // Many premium details belong to one user.
    @JoinColumn(name = "user_id", nullable = false)    // Foreign key to "vehicleusers" table
    @JsonIgnore //Prevents circular reference
    private VehicleUser user;

    // Constructors
    public PremiumDetails() {}

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public VehicleUser getUser() {
        return user;
    }

    public void setUser(VehicleUser user) {
        this.user = user;
    }

    // toString Method
    @Override
    public String toString() {
        return "PremiumDetails{" +
                "id=" + id +
                ", planName='" + planName + '\'' +
                ", amount=" + amount +
                ", startDate=" + startDate +
                ", expiryDate=" + expiryDate +
                '}';
    }
}


