package com.hust.aims.subsystem.vnpaysubsystem;

import com.hust.aims.entities.customer.PaymentTransaction;
import com.hust.aims.module.Invoice;
import com.hust.aims.subsystem.IPayment;


import java.time.Instant;

public class VnPaySubSystem implements IPayment {

    @Override
    public PaymentTransaction payOrder(Invoice invoice){
        PaymentTransaction paymentTransaction =  new PaymentTransaction();
        paymentTransaction.setStatus("Success");
        paymentTransaction.setCustomer(invoice.getOrder().getUser());
        paymentTransaction.setCreatedTime(Instant.now());
        return paymentTransaction;
    }
}
