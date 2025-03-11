package com.example.service; 

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.ResourceNotFoundException;
import com.example.model.PremiumDetails;
import com.example.model.VehicleUser;
import com.example.repository.PremiumDetailsRepository;
import com.example.repository.VehicleUserRepository;

@Service
public class VehicleUserServiceImpl implements VehicleUserService {

    @Autowired
    private VehicleUserRepository vehicleUserRepository;

    @Autowired
    private PremiumDetailsRepository premiumDetailsRepository; // ✅ Missing repository added

    @Override
    public List<PremiumDetails> getPremiumDetailsByUserId(Long userId) {
        VehicleUser user = vehicleUserRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with ID " + userId + " not found"));

        List<PremiumDetails> premiumDetails = premiumDetailsRepository.findByUser_Id(userId);
        if (premiumDetails.isEmpty()) {
            throw new ResourceNotFoundException("No premium details found for User ID " + userId);
        }

        return premiumDetails;
    }
}
