package com.hust.aims.module;

import com.hust.aims.entities.customer.DeliveryInfo;
import com.hust.aims.entities.order.Order;

public class Invoice {
    private Order order;

    private DeliveryInfo deliveryInfo;

    public Invoice(DeliveryInfo deliveryInfo, Order order) {
        this.deliveryInfo = deliveryInfo;
        this.order = order;
    }


    public DeliveryInfo getDeliveryInfo() {
        return deliveryInfo;
    }

    public void setDeliveryInfo(DeliveryInfo deliveryInfo) {
        this.deliveryInfo = deliveryInfo;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
