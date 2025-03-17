package com.vihiclePoject.service;


import java.util.List;
import java.util.Optional;

import com.vihiclePoject.model.Policy;

public interface PolicyService {
    List<Policy> getAllPolices();

	Optional<Policy> getPolicyById(Long policyid);

	List<Policy> getPolicyByName(String policyName);
    
}
