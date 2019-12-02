package com.tinhpt.order.service;

import com.tinhpt.order.dto.OrderResponse;

import java.util.List;

public interface IOrderService {
    List<OrderResponse> findOrderByCustomerId(Long customerId);
}
