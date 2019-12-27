package com.tinhpt.order.dto;

import lombok.Data;

@Data
public class CommissionResponse {
    private Long orderId;
    private String customerName;
    private OrderResponse order;
    private Long value;
    private Long valueVat;
}
