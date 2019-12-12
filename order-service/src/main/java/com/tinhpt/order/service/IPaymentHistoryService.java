package com.tinhpt.order.service;

import com.tinhpt.order.dto.PaymentResponse;
import com.tinhpt.order.specification.PaymentHistorySpec;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPaymentHistoryService {
    List<PaymentResponse> findPaymentHistoryByOrderId(Long orderId);
    Page<PaymentResponse> findAll(PaymentHistorySpec specs, Pageable pageable);
}
