package com.tinhpt.order.service;

import com.tinhpt.common.security.JwtConfig;
import com.tinhpt.common.utils.JwtUtils;
import com.tinhpt.order.dto.CustomerResponse;
import com.tinhpt.order.dto.OrderResponse;
import com.tinhpt.order.dto.SaleResponse;
import com.tinhpt.order.entities.CustomerEntity;
import com.tinhpt.order.entities.OrderEntity;
import com.tinhpt.order.repository.CustomerDao;
import com.tinhpt.order.repository.OrderDao;
import com.tinhpt.order.utils.RestUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService implements ICustomerService {

    private final String HR_EMPLOYEE_API = "http://hr-service/employees/";

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private JwtConfig jwtConfig;

    @Override
    public List<CustomerResponse> getAllCustomer() {
        return customerDao.findAll().stream().map(this::convertEntityToDTO).collect(Collectors.toList());
    }

    private CustomerEntity findCustomerById(Long id) {
        return customerDao.findById(id).orElseThrow(() -> new RuntimeException("Cannot find customer with id=" + id));
    }

    @Override
    public CustomerResponse findById(Long id) {
        CustomerEntity customerEntity = findCustomerById(id);
        return convertEntityToDTO(customerEntity);
    }

    @Override
    public List<OrderResponse> findByCustomerId(Long customerId) {
        return orderDao.findByCustomer(findCustomerById(customerId)).stream().map(this::convertOrderEntityToDTO).collect(Collectors.toList());
    }

    private OrderResponse convertOrderEntityToDTO(OrderEntity entity) {
        OrderResponse response = new OrderResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }

    private CustomerResponse convertEntityToDTO(CustomerEntity entity) {
        CustomerResponse response = new CustomerResponse();
        BeanUtils.copyProperties(entity, response);
        HttpEntity httpEntity = RestUtils.createHttpHeaderEntity(jwtConfig);
        if (entity.getTeleSaleId() != null) {
            SaleResponse teleSale = restTemplate.exchange(HR_EMPLOYEE_API + entity.getTeleSaleId().toString(), HttpMethod.GET, httpEntity, SaleResponse.class).getBody();
            response.setTeleSale(teleSale);
        }
        if (entity.getSaleId() != null) {
            SaleResponse sale = restTemplate.exchange(HR_EMPLOYEE_API + entity.getSaleId().toString(), HttpMethod.GET, httpEntity, SaleResponse.class).getBody();
            response.setSale(sale);
        }
        if (entity.getSaleAdminId() != null) {
            SaleResponse saleAdmin = restTemplate.exchange(HR_EMPLOYEE_API + entity.getSaleAdminId().toString(), HttpMethod.GET, httpEntity, SaleResponse.class).getBody();
            response.setSaleAdmin(saleAdmin);
        }
        if (entity.getSaleManagerId() != null) {
            SaleResponse saleManager = restTemplate.exchange(HR_EMPLOYEE_API + entity.getSaleManagerId().toString(), HttpMethod.GET, httpEntity, SaleResponse.class).getBody();
            response.setSaleManager(saleManager);
        }
        return response;
    }
}
