package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Driver;

public interface DriverRepository extends JpaRepository<Driver,String> {

}
