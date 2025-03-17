package com.vihiclePoject.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vihiclePoject.exception.PolicyNotFoundException;
import com.vihiclePoject.model.Policy;
import com.vihiclePoject.repository.PolicyRepository;
import com.vihiclePoject.service.PolicyService;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyServiceImpl implements PolicyService {

    private static final Logger logger = LoggerFactory.getLogger(PolicyServiceImpl.class);

    @Autowired
    private PolicyRepository policyRepository;

    @Override
    public List<Policy> getAllPolices() {
        logger.info("Fetching all policies");
        List<Policy> policies = policyRepository.findAll();
        if (policies.isEmpty()) {
            logger.warn("No policies found");
            throw new PolicyNotFoundException("No policies available");
        }
        return policies;
    }

    @Override
    public Optional<Policy> getPolicyById(Long policyId) {
        logger.info("Fetching policy by ID: {}", policyId);
        Optional<Policy> policy = policyRepository.findById(policyId);
        
        if (policy.isEmpty()) {
            logger.warn("Policy not found with ID: {}", policyId);
            throw new PolicyNotFoundException("Policy not found with ID: " + policyId);
        }
        
        return policy;
    }

    @Override
    public List<Policy> getPolicyByName(String policyName) {
        logger.info("Fetching policy by Name: {}", policyName);
        List<Policy> policies = policyRepository.findByPolicyName(policyName);
        if (policies.isEmpty()) {
            logger.warn("Policy not found with Name: {}", policyName);
            throw new PolicyNotFoundException("Policy not found with Name: " + policyName);
        }
        return policies;
    }
}
