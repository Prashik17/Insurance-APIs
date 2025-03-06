package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.TrafficViolation;
import com.example.demo.service.TrafficViolationService;

@RestController
@RequestMapping("/api/violations")
public class TrafficViolationController {
	
	 @Autowired
	    private TrafficViolationService trafficViolationService;

	    
	    @PostMapping
	    public ResponseEntity<TrafficViolation> addViolation(@RequestBody TrafficViolation violation) {
	        TrafficViolation savedViolation = trafficViolationService.saveViolation(violation);
	        return new ResponseEntity<>(savedViolation, HttpStatus.CREATED);
	    }

	    
	    @GetMapping("/{vehicleNumber}")
	    public ResponseEntity<TrafficViolation> getViolation(@PathVariable String vehicleNumber) {
	        Optional<TrafficViolation> violation = trafficViolationService.getViolation(vehicleNumber);
	        return violation.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }
}
