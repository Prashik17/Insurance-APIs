package com.insurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.exception.BillNotFoundException;
import com.insurance.model.Bill;
import com.insurance.model.PaymentStatus;
import com.insurance.repository.BillRepository;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillRepository billRepository;//Allows this service class to access database operations without manually creating a BillRepository object.

    @Override
    public Bill createBill(Bill bill) {
        bill.setPaymentStatus(PaymentStatus.PENDING);
        return billRepository.save(bill);
    }

    @Override
    public Bill getBillById(Long id) {
        return billRepository.findById(id)
                .orElseThrow(() -> new BillNotFoundException("Bill with ID " + id + " not found"));
    }

    @Override
    public List<Bill> getBillsByUserId(Long userId) {
        return billRepository.findByUserId(userId);
    }

    @Override     //Ensures only valid PaymentStatus values (PENDING, PAID, FAILED) are used.
    public Bill updatePaymentStatus(Long id, PaymentStatus newStatus) {
        Bill bill = getBillById(id);
        bill.setPaymentStatus(newStatus);
        return billRepository.save(bill);
    }
}

