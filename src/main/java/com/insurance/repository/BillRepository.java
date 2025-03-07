package com.insurance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.model.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
    List<Bill> findByUserId(Long userId);
}