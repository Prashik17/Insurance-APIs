package com.insurance.service;

import com.insurance.model.User;
import com.insurance.model.Vehicle;
import com.insurance.repository.UserRepository;
import com.insurance.repository.VehicleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

	   @Autowired
	    private VehicleRepository vehicleRepository;

	    public Vehicle saveVehicle(Vehicle vehicle) {
	        return vehicleRepository.save(vehicle);
	    }

	    public List<Vehicle> getAllVehiclesByUserId(Long userId) {
	        return vehicleRepository.findByUserId(userId);
	    }

	    public Optional<Vehicle> getVehicleById(Long vehicleId) {
	        return vehicleRepository.findById(vehicleId);
	    }

	    public void deleteVehicle(Long vehicleId) {
	        vehicleRepository.deleteById(vehicleId);
	    }
}