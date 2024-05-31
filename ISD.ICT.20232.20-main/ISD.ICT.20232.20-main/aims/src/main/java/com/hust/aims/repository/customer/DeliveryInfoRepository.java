package com.hust.aims.repository.customer;

import com.hust.aims.entities.customer.DeliveryInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryInfoRepository extends JpaRepository<DeliveryInfo, Integer> {
}