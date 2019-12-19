package com.tinhpt.order.service;

import com.tinhpt.order.dto.PaymentResponse;
import com.tinhpt.order.repository.OrderDao;
import com.tinhpt.order.repository.PaymentHistoryDao;
import com.tinhpt.order.specification.PaymentHistorySpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
                .stream().map(EntityDTOUtils::mapPaymentHistoryEntityToDTO).collect(Collectors.toList());
    }

    @Override
    public Page<PaymentResponse> findAll(PaymentHistorySpec specs, Pageable pageable) {
        return paymentHistoryDao.findAll(specs, pageable).map(EntityDTOUtils::mapPaymentHistoryEntityToDTO);
    }
}
