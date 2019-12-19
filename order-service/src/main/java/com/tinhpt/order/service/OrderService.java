package com.tinhpt.order.service;

import com.tinhpt.order.dto.OrderResponse;
import com.tinhpt.order.repository.CustomerDao;
import com.tinhpt.order.repository.OrderDao;
import com.tinhpt.order.specification.OrderSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private CustomerDao customerDao;

    @Override
    public List<OrderResponse> findOrderByCustomerId(Long customerId) {
        return orderDao.findByCustomer(customerDao.findById(customerId).orElseThrow(() -> new RuntimeException("cannot find customer"))).stream().map
                (EntityDTOUtils::mapOrderEntityToDTO).collect(Collectors.toList());
    }

    @Override
    public OrderResponse findById(Long id) {
        return EntityDTOUtils.mapOrderEntityToDTO(orderDao.findById(id).orElseThrow(() -> new RuntimeException("Can not find order")));
    }

    @Override
    public Page<OrderResponse> findAll(OrderSpec specs, Pageable pageable) {
        return orderDao.findAll(specs, pageable).map(EntityDTOUtils::mapOrderEntityToDTO);
    }
}
