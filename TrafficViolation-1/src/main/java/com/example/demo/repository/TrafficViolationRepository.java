package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.TrafficViolation;

public interface TrafficViolationRepository extends JpaRepository<TrafficViolation, String> {

}
