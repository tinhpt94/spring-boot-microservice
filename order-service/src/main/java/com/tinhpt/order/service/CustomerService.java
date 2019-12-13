package com.tinhpt.order.service;

import com.tinhpt.order.dto.CustomerResponse;
import com.tinhpt.order.entities.CustomerEntity;
import com.tinhpt.order.repository.CustomerDao;
import com.tinhpt.order.repository.OrderDao;
import com.tinhpt.order.specification.CustomerSpec;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private OrderDao orderDao;

    @Override
    public List<CustomerResponse> getAllCustomer(CustomerSpec customerSpec) {
        return customerDao.findAll(customerSpec).stream().map(this::convertEntityToDTO).collect(Collectors.toList());
    }

    private CustomerEntity findCustomerById(Long id) {
        return customerDao.findById(id).orElseThrow(() -> new RuntimeException("Cannot find customer with id=" + id));
    }

    @Override
    public CustomerResponse findById(Long id) {
        CustomerEntity customerEntity = findCustomerById(id);
        return convertEntityToDTO(customerEntity);
    }

    private CustomerResponse convertEntityToDTO(CustomerEntity entity) {
        CustomerResponse response = new CustomerResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }
}
