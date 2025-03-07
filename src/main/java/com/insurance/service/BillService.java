package com.insurance.service;

import java.util.List;

import com.insurance.model.Bill;
import com.insurance.model.PaymentStatus;

public interface BillService {
    Bill createBill(Bill bill);
    Bill getBillById(Long id);
    List<Bill> getBillsByUserId(Long userId);
    Bill updatePaymentStatus(Long id, PaymentStatus newStatus);
    //Accepts a Long ID and a PaymentStatus enum value (PENDING, PAID, FAILED).
   // Returns the updated Bill object
}