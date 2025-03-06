package com.example.demo.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TrafficViolation {
	
	@Id
    private String vehicleNumber;
    private String violationCode;
    private String violationDescription;
    private Date violationDate;
    private Double fineAmount;
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getViolationCode() {
		return violationCode;
	}
	public void setViolationCode(String violationCode) {
		this.violationCode = violationCode;
	}
	public String getViolationDescription() {
		return violationDescription;
	}
	public void setViolationDescription(String violationDescription) {
		this.violationDescription = violationDescription;
	}
	public Date getViolationDate() {
		return violationDate;
	}
	public void setViolationDate(Date violationDate) {
		this.violationDate = violationDate;
	}
	public Double getFineAmount() {
		return fineAmount;
	}
	public void setFineAmount(Double fineAmount) {
		this.fineAmount = fineAmount;
	}
    
    
	
}
