package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Driver;
import com.example.demo.repository.DriverRepository;

@Service
public class DriverService {
		
	    @Autowired
		private DriverRepository dr;
	    
	    public Driver savedata(Driver driver) {
	    	Driver d=dr.save(driver);
	    	return d;
	    }
	    
	    public Optional<Driver> getDriver(String vehicleNumber) {
	        return dr.findById(vehicleNumber);
	    }
	    
	    public List<Driver> getAllDrivers() {
	        return dr.findAll();
	    }
	    
	    public void deleteDriver(String vehicleNumber) {
	        dr.deleteById(vehicleNumber);
	    }
}
