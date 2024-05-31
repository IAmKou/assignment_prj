package com.hust.aims.entities.customer;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "delivery_info")
public class DeliveryInfo {
    @Id
    @Column(name = "delivery_id", nullable = false)
    private Integer id;

    @Column(name = "address", length = Integer.MAX_VALUE)
    private String address;

    @Column(name = "delivery_time")
    private Instant deliveryTime;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "instructions", length = Integer.MAX_VALUE)
    private String instructions;

    @Column(name = "type")
    private Boolean type;

    @Column(name = "receiver_name")
    private String receiverName;

    @Column(name = "province")
    private String province;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Customer user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Instant getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Instant deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Customer getUser() {
        return user;
    }

    public void setUser(Customer user) {
        this.user = user;
    }

}