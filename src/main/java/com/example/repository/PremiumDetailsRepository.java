package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.PremiumDetails;

@Repository
public interface PremiumDetailsRepository extends JpaRepository<PremiumDetails, Long> {
	List<PremiumDetails> findByUser_Id(Long userId);

}