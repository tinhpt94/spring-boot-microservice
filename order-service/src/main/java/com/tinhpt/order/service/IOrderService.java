package com.tinhpt.order.service;

import com.tinhpt.order.dto.OrderResponse;
import com.tinhpt.order.specification.OrderSpec;

import java.util.List;

public interface IOrderService {
    List<OrderResponse> findOrderByCustomerId(Long customerId);
    OrderResponse findById(Long id);
    List<OrderResponse> findAll();
}
