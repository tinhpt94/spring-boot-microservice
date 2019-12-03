package com.tinhpt.order.service;

import com.tinhpt.order.dto.PaymentResponse;
import com.tinhpt.order.entities.PaymentHistoryEntity;
import com.tinhpt.order.repository.OrderDao;
import com.tinhpt.order.repository.PaymentHistoryDao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentHistoryService implements IPaymentHistoryService {

    @Autowired
    private PaymentHistoryDao paymentHistoryDao;

    @Autowired
    private OrderDao orderDao;

    @Override
    public List<PaymentResponse> findPaymentHistoryByOrderId(Long orderId) {
        return paymentHistoryDao.findByOrder(
                    orderDao.findById(orderId).orElseThrow(() -> new RuntimeException("Cannot find order")))
                .stream().map(this::convertEntityToDTO).collect(Collectors.toList());
    }

    private PaymentResponse convertEntityToDTO(PaymentHistoryEntity entity) {
        PaymentResponse response = new PaymentResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }
}
