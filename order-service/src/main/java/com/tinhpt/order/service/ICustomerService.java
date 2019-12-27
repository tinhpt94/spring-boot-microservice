package com.tinhpt.order.service;

import com.tinhpt.order.dto.CustomerResponse;
import com.tinhpt.order.specification.CustomerSpec;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<CustomerResponse> getAllCustomer(CustomerSpec customerSpec, Pageable pageable);
    CustomerResponse findById(Long id);
}
