package com.tinhpt.order.service;

import com.tinhpt.order.dto.CustomerResponse;
import com.tinhpt.order.entities.CustomerEntity;
import com.tinhpt.order.repository.CustomerDao;
import com.tinhpt.order.specification.CustomerSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public Page<CustomerResponse> getAllCustomer(CustomerSpec customerSpec, Pageable pageable) {
        return customerDao.findAll(customerSpec, pageable).map(EntityDTOUtils::mapCustomerEntityToDTO);
    }

    private CustomerEntity findCustomerById(Long id) {
        return customerDao.findById(id).orElseThrow(() -> new RuntimeException("Cannot find customer with id=" + id));
    }

    @Override
    public CustomerResponse findById(Long id) {
        CustomerEntity customerEntity = findCustomerById(id);
        return EntityDTOUtils.mapCustomerEntityToDTO(customerEntity);
    }


}
