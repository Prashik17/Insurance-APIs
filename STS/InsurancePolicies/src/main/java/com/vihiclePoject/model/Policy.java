package com.vihiclePoject.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Insurance_policies")
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long policyId;

    @Column(name = "policy_name")
    private String policyName;

    @Column(name = "coverage")
    private String coverage;

    @Column(name = "premium_amount")
    private Double premiumAmount;

    @Column(name = "policy_duration")
    private int duration;

    public Policy() {}

    // Getters and Setters
    public Long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Long policyId) {
        this.policyId = policyId;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public String getCoverage() {
        return coverage;
    }

    public void setCoverage(String coverage) {
        this.coverage = coverage;
    }

    public Double getPremiumAmount() {
        return premiumAmount;
    }

    public void setPremiumAmount(Double premiumAmount) {
        this.premiumAmount = premiumAmount;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
