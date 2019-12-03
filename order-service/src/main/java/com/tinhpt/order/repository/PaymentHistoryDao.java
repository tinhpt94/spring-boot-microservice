package com.tinhpt.order.repository;

import com.tinhpt.order.entities.OrderEntity;
import com.tinhpt.order.entities.PaymentHistoryEntity;

import java.util.List;

public interface PaymentHistoryDao extends BaseDao<PaymentHistoryEntity, Long> {
    List<PaymentHistoryEntity> findByOrder(OrderEntity orderEntity);
}
