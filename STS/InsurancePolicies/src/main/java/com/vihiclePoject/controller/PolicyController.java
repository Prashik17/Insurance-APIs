package com.vihiclePoject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.vihiclePoject.model.Policy;
import com.vihiclePoject.service.PolicyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    private static final Logger logger = LoggerFactory.getLogger(PolicyController.class);

    @GetMapping("/policy")
    public List<Policy> getAllPolices() {
        try {
            return policyService.getAllPolices();
        } catch (Exception e) {
            logger.error("Error fetching all policies", e);
            throw e;
        }
    }

    @GetMapping("/policy/{policyid}")
    public Optional<Policy> getPolicyById(@PathVariable Long policyid) {
        try {
            return policyService.getPolicyById(policyid);
        } catch (Exception e) {
            logger.error("Error fetching policy by ID: " + policyid, e);
            throw e;
        }
    }

    @GetMapping("/policy/byName")
    public List<Policy> getPolicyByName(@RequestParam String policyName) {
        try {
            return policyService.getPolicyByName(policyName);
        } catch (Exception e) {
            logger.error("Error fetching policy by name: " + policyName, e);
            throw e;
        }
    }
} 
