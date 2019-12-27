package com.tinhpt.order.service;

import com.tinhpt.order.dto.CommissionResponse;
import com.tinhpt.order.entities.InComeReport;
import com.tinhpt.order.entities.OrderEntity;
import com.tinhpt.order.repository.OrderDao;
import com.tinhpt.order.repository.PaymentHistoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommissionService implements ICommissionService {

    @Autowired
    private PaymentHistoryDao paymentHistoryDao;

    @Autowired
    private OrderDao orderDao;

    @Override
    public List<CommissionResponse> getCommissionReport(LocalDateTime startDate, LocalDateTime endDate) {
        return paymentHistoryDao.getInComeReport(startDate, endDate).stream().map(this::mapCommissionReportToResponse).collect(Collectors.toList());
    }

    private CommissionResponse mapCommissionReportToResponse(InComeReport inComeReport) {
        CommissionResponse response = new CommissionResponse();
        response.setOrderId(inComeReport.getOrderId());
        response.setValue(inComeReport.getValue());
        response.setValueVat(inComeReport.getValueVat());
        OrderEntity orderEntity = orderDao.findById(inComeReport.getOrderId()).get();
        response.setOrder(EntityDTOUtils.mapOrderEntityToDTO(orderEntity));
        response.setCustomerName(orderEntity.getCustomer().getName());
        return response;
    }
}
