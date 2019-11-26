package com.tinhpt.order.repository;

import com.tinhpt.order.entities.CustomerEntity;
import com.tinhpt.order.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDao extends JpaRepository<OrderEntity, Long> {
    List<OrderEntity> findByCustomer(CustomerEntity customer);
}
