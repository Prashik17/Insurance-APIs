package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Driver;
import com.example.demo.service.DriverService;

@RestController
@RequestMapping("/drivers")
public class DriverController {
	
	@Autowired
    private DriverService driverService;
	
		@GetMapping
	    public List<Driver> getAllDrivers() {
	        return driverService.getAllDrivers();
	    }

		@GetMapping("/{vehicleNumber}")
	    public ResponseEntity<Driver> getDriver(@PathVariable String vehicleNumber) {
	        Optional<Driver> driver = driverService.getDriver(vehicleNumber);
	        if (driver.isPresent()) {
	            return ResponseEntity.ok(driver.get());
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    // Create or update driver
	    @PostMapping
	    public Driver createOrUpdateDriver(@RequestBody Driver driver) {
	        return driverService.savedata(driver);
	    }

	    // Delete driver by Vehicle Number
	    @DeleteMapping("/{vehicleNumber}")
	    public ResponseEntity<Void> deleteDriver(@PathVariable String vehicleNumber) {
	        driverService.deleteDriver(vehicleNumber);
	        return ResponseEntity.noContent().build();
	    }
}
