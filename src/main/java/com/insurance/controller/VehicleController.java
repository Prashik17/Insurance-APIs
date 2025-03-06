package com.insurance.controller;
//src/main/java/com/example/demo/controller/VehicleController.java



import com.insurance.model.User;
import com.insurance.model.Vehicle;
import com.insurance.repository.UserRepository;
import com.insurance.service.VehicleService;
import com.insurance.config.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<String> registerVehicle(
            @RequestBody Vehicle vehicle,
            @RequestHeader("Authorization") String token) {

        // Extract userId from JWT
        String jwt = token.substring(7); // Remove "Bearer " prefix
        Long userId = jwtUtil.extractUserId(jwt);

        // Find user and map to vehicle
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        vehicle.setUser(user);
        vehicleService.saveVehicle(vehicle);

        return ResponseEntity.ok("Vehicle registered successfully!");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Vehicle>> getAllVehicles(@RequestHeader("Authorization") String token) {
        Long userId = jwtUtil.extractUserId(token.substring(7));
        return ResponseEntity.ok(vehicleService.getAllVehiclesByUserId(userId));
    }

    @GetMapping("/{vehicleId}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long vehicleId) {
        return vehicleService.getVehicleById(vehicleId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/update/{vehicleId}")
    public ResponseEntity<String> updateVehicle(
            @PathVariable Long vehicleId,
            @RequestBody Vehicle updatedVehicle) {

        Vehicle vehicle = vehicleService.getVehicleById(vehicleId)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        vehicle.setVehicleNumber(updatedVehicle.getVehicleNumber());
        vehicle.setRegistrationNumber(updatedVehicle.getRegistrationNumber());
        vehicle.setBrand(updatedVehicle.getBrand());
        vehicle.setModel(updatedVehicle.getModel());
        vehicle.setColor(updatedVehicle.getColor());
        vehicle.setEngineNumber(updatedVehicle.getEngineNumber());
        vehicle.setChassisNumber(updatedVehicle.getChassisNumber());

        vehicleService.saveVehicle(vehicle);

        return ResponseEntity.ok("Vehicle updated successfully!");
    }

    @DeleteMapping("/delete/{vehicleId}")
    public ResponseEntity<String> deleteVehicle(@PathVariable Long vehicleId) {
        vehicleService.deleteVehicle(vehicleId);
        return ResponseEntity.ok("Vehicle deleted successfully!");
    }
}