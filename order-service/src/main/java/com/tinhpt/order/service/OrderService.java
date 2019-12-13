package com.tinhpt.order.service;

import com.tinhpt.order.config.JwtConfig;
import com.tinhpt.order.dto.OrderResponse;
import com.tinhpt.order.dto.SaleResponse;
import com.tinhpt.order.entities.OrderEntity;
import com.tinhpt.order.repository.CustomerDao;
import com.tinhpt.order.repository.OrderDao;
import com.tinhpt.order.specification.OrderSpec;
import com.tinhpt.order.utils.RestUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService implements IOrderService {

    private final String HR_EMPLOYEE_API = "http://hr-service/employees/";

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private JwtConfig jwtConfig;

    @Override
    public List<OrderResponse> findOrderByCustomerId(Long customerId) {
        return orderDao.findByCustomer(customerDao.findById(customerId).orElseThrow(() -> new RuntimeException("cannot find customer"))).stream().map
                (this::mapEntityToDTO).collect(Collectors.toList());
    }

    @Override
    public OrderResponse findById(Long id) {
        return mapEntityToDTO(orderDao.findById(id).orElseThrow(() -> new RuntimeException("Can not find order")));
    }

    @Override
    public Page<OrderResponse> findAll(OrderSpec specs, Pageable pageable) {
        return orderDao.findAll(specs, pageable).map(this::mapEntityToDTO);
    }

    private OrderResponse mapEntityToDTO(OrderEntity entity) {
        OrderResponse response = new OrderResponse();
        BeanUtils.copyProperties(entity, response);
//        HttpEntity httpEntity = RestUtils.createHttpHeaderEntity(jwtConfig);
//        if (entity.getTeleSaleId() != null) {
//            SaleResponse teleSale = restTemplate.exchange(HR_EMPLOYEE_API + entity.getTeleSaleId().toString(), HttpMethod.GET, httpEntity, SaleResponse.class).getBody();
//            response.setTeleSale(teleSale);
//        }
//        if (entity.getSaleId() != null) {
//            SaleResponse sale = restTemplate.exchange(HR_EMPLOYEE_API + entity.getSaleId().toString(), HttpMethod.GET, httpEntity, SaleResponse.class).getBody();
//            response.setSale(sale);
//        }
//        if (entity.getSaleAdminId() != null) {
//            SaleResponse saleAdmin = restTemplate.exchange(HR_EMPLOYEE_API + entity.getSaleAdminId().toString(), HttpMethod.GET, httpEntity, SaleResponse.class).getBody();
//            response.setSaleAdmin(saleAdmin);
//        }
//        if (entity.getSaleManagerId() != null) {
//            SaleResponse saleManager = restTemplate.exchange(HR_EMPLOYEE_API + entity.getSaleManagerId().toString(), HttpMethod.GET, httpEntity, SaleResponse.class).getBody();
//            response.setSaleManager(saleManager);
//        }
        response.setCardName(entity.getCardDetail().toString());
        return response;
    }
}
