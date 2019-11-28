package com.tinhpt.order.repository;

import com.tinhpt.order.entities.CustomerEntity;
import com.tinhpt.order.entities.OrderEntity;

import java.util.List;

public interface OrderDao extends BaseDao<OrderEntity, Long> {
    List<OrderEntity> findByCustomer(CustomerEntity customer);
}
