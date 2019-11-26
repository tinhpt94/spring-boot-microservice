package com.tinhpt.order.service;

import com.tinhpt.order.dto.CustomerResponse;
import com.tinhpt.order.dto.OrderResponse;

import java.util.List;

public interface ICustomerService {
    List<CustomerResponse> getAllCustomer();
    CustomerResponse findById(Long id);
    List<OrderResponse> findByCustomerId(Long customerId);
}
