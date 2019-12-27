package com.tinhpt.order.repository;

import com.tinhpt.order.entities.InComeReport;
import com.tinhpt.order.entities.OrderEntity;
import com.tinhpt.order.entities.PaymentHistoryEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface PaymentHistoryDao extends BaseDao<PaymentHistoryEntity, Long> {
    List<PaymentHistoryEntity> findByOrder(OrderEntity orderEntity);

    @Query("SELECT new com.tinhpt.order.entities.InComeReport(p.order.id, sum(p.value), sum(p.valueVat)) " +
            "FROM PaymentHistoryEntity p " +
            "WHERE p.date BETWEEN :startDate AND :endDate " +
            "AND p.status = 'Xác nhận khoản thu'" +
            "GROUP BY p.order.id " +
            "ORDER BY p.order.id ASC"
    )
    List<InComeReport> getInComeReport(@Param("startDate") LocalDateTime startDate,
                                       @Param("endDate") LocalDateTime endDate);
}