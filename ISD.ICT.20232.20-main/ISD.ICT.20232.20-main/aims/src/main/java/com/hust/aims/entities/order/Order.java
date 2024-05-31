package com.hust.aims.entities.order;

import com.hust.aims.entities.customer.Customer;
import com.hust.aims.entities.customer.DeliveryInfo;
import com.hust.aims.entities.customer.PaymentTransaction;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "order_id", nullable = false)
    private Integer id;

    @Column(name = "total_price")
    private Float totalPrice;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @Column(name = "shipping_fee")
    private Float shippingFee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id")
    private PaymentTransaction payment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Customer user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private DeliveryInfo delivery;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public Float getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(Float shippingFee) {
        this.shippingFee = shippingFee;
    }

    public PaymentTransaction getPayment() {
        return payment;
    }

    public void setPayment(PaymentTransaction payment) {
        this.payment = payment;
    }

    public Customer getUser() {
        return user;
    }

    public void setUser(Customer user) {
        this.user = user;
    }

    public DeliveryInfo getDelivery() {
        return delivery;
    }

    public void setDelivery(DeliveryInfo delivery) {
        this.delivery = delivery;
    }

}