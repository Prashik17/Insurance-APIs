package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TrafficViolation;
import com.example.demo.repository.TrafficViolationRepository;

@Service
public class TrafficViolationService {
		
	@Autowired
    private TrafficViolationRepository trafficViolationRepository;

    public TrafficViolation saveViolation(TrafficViolation violation) {
        return trafficViolationRepository.save(violation);
    }

    public Optional<TrafficViolation> getViolation(String vehicleNumber) {
        return trafficViolationRepository.findById(vehicleNumber);
    }
}
