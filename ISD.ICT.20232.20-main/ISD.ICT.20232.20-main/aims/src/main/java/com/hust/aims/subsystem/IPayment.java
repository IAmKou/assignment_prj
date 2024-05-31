package com.hust.aims.subsystem;

import com.hust.aims.entities.customer.PaymentTransaction;
import com.hust.aims.module.Invoice;

public interface IPayment {
    public PaymentTransaction payOrder(Invoice invoice);
}
