package com.tinhpt.order.service;

import com.tinhpt.order.dto.CustomerResponse;
import com.tinhpt.order.dto.OrderResponse;
import com.tinhpt.order.specification.CustomerSpec;

import java.util.List;

public interface ICustomerService {
    List<CustomerResponse> getAllCustomer(CustomerSpec customerSpec);
    CustomerResponse findById(Long id);
}
