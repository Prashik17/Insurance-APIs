package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.PremiumDetails;
import com.example.service.VehicleUserService;

@RestController
@RequestMapping("/api/premium")
public class VehicleUserController {

    @Autowired
    private VehicleUserService vehicleUserService;

    @GetMapping("/user/{id}")
    public ResponseEntity<List<PremiumDetails>> getPremiumDetailsByUserId(@PathVariable Long id) {
        List<PremiumDetails> premiumDetails = vehicleUserService.getPremiumDetailsByUserId(id);
        return ResponseEntity.ok(premiumDetails);
    }
}