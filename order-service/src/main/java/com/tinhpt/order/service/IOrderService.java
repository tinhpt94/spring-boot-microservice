package com.tinhpt.order.service;

import com.tinhpt.order.dto.OrderResponse;
import com.tinhpt.order.specification.OrderSpec;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IOrderService {
    List<OrderResponse> findOrderByCustomerId(Long customerId);
    OrderResponse findById(Long id);
    Page<OrderResponse> findAll(OrderSpec specs, Pageable pageable);
}
