package com.tinhpt.order.dto;

import lombok.Data;

@Data
public class SaleResponse {
    private Long id;
    private String name;
    private Double commissionRate;
}
