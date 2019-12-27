package com.tinhpt.order.service;

import com.tinhpt.order.dto.CommissionResponse;

import java.time.LocalDateTime;
import java.util.List;

public interface ICommissionService {
    List<CommissionResponse> getCommissionReport(LocalDateTime startDate, LocalDateTime endDate);
}
