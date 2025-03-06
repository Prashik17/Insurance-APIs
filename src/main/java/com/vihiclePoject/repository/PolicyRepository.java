package com.vihiclePoject.repository;





import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vihiclePoject.model.Policy;

public interface PolicyRepository extends JpaRepository<Policy, Long> {

	List<Policy> findByPolicyName(String policyName);

	

}
