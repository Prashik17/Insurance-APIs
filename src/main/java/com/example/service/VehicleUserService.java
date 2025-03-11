package com.example.service;

import java.util.List;

import com.example.model.PremiumDetails;

public interface VehicleUserService {
    List<PremiumDetails> getPremiumDetailsByUserId(Long userId);
}