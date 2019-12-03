package com.tinhpt.order.service;

import com.tinhpt.order.dto.PaymentResponse;

import java.util.List;

public interface IPaymentHistoryService {
    List<PaymentResponse> findPaymentHistoryByOrderId(Long orderId);
}
