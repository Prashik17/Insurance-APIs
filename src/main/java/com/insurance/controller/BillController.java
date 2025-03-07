package com.insurance.controller;

//this api controller exposes endpoints for creating bills, retrieving bills, fetching a user's billing history, and updating the payment status.

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.model.Bill;
import com.insurance.model.PaymentStatus;
import com.insurance.service.BillService;


@RestController
@RequestMapping("/bills") // Base path for all requests
public class BillController {

    @Autowired
    private BillService billService;

    @PostMapping
    public Bill createBill(@RequestBody Bill bill) {
        return billService.createBill(bill);
    }

    @GetMapping("/{id}")
    public Bill getBillById(@PathVariable Long id) {
        return billService.getBillById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Bill> getBillsByUserId(@PathVariable Long userId) {
        return billService.getBillsByUserId(userId);
    }

    @PutMapping("/{id}")
    public Bill updatePaymentStatus(@PathVariable Long id, @RequestBody PaymentStatus newStatus) {
        return billService.updatePaymentStatus(id, newStatus);
    }
}

