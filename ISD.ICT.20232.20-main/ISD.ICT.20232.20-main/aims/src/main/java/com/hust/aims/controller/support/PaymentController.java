package com.hust.aims.controller.support;

import com.hust.aims.entities.customer.PaymentTransaction;
import com.hust.aims.repository.customer.PaymentTransactionRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class PaymentController {

    private final PaymentTransactionRepository paymentTransactionRepository;

    public PaymentController(PaymentTransactionRepository paymentTransactionRepository) {
        this.paymentTransactionRepository = paymentTransactionRepository;
    }

    public void savePaymentTransaction(PaymentTransaction paymentTransaction) {
        paymentTransaction.setCreatedTime(Instant.now());
        paymentTransactionRepository.save(paymentTransaction);
    }
}
