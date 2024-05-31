package com.hust.aims.repository.order;

import com.hust.aims.entities.order.OrderProduct;
import com.hust.aims.entities.order.OrderProductId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, OrderProductId> {
}