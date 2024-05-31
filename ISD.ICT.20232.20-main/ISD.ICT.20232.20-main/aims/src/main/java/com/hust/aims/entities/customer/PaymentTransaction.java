package com.hust.aims.entities.customer;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "payment_transaction")
public class PaymentTransaction {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "status")
    private String status;

    @Column(name = "created_time")
    private Instant createdTime;

    @Column(name = "content", length = Integer.MAX_VALUE)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Instant getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Instant createdTime) {
        this.createdTime = createdTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}