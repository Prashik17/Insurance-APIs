package com.insurance.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "bills")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Auto-generates unique IDs using the database's identity column.Avoids manual ID assignment and prevents duplicate keys.
    private Long billId;

    private Long userId;
    private Long vehicleId;
    private Long policyId;
    private Double amount;
    
    
    //Enum Field =Enum enforces predefined values, preventing invalid status entries (Payment Status e.g. PENDING, PAID)
    
    @Enumerated(EnumType.STRING)       //Stores the enum value as a String in the database.
    @Column(nullable = false)           //ensures every bill has a valid status.
    private PaymentStatus paymentStatus;
    

    //Timestamp Fields
    @Column(updatable = false)//Prevents createdAt from being modified after insertion.
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    

    @PrePersist          //Executes before inserting a new record into the database.
    protected void onCreate() {
        createdAt = LocalDateTime.now();//Sets createdAt and updatedAt to the current time when a new bill is inserted.
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate          //Executes before updating an existing record. Updates updatedAt timestamp automatically before modifying the record.
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getBillId() { return billId; }
    public void setBillId(Long billId) { this.billId = billId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getVehicleId() { return vehicleId; }
    public void setVehicleId(Long vehicleId) { this.vehicleId = vehicleId; }

    public Long getPolicyId() { return policyId; }
    public void setPolicyId(Long policyId) { this.policyId = policyId; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public PaymentStatus getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(PaymentStatus paymentStatus) { this.paymentStatus = paymentStatus; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }

	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", userId=" + userId + ", vehicleId=" + vehicleId + ", policyId=" + policyId
				+ ", amount=" + amount + ", paymentStatus=" + paymentStatus + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}
    
}