package com.tinhpt.order.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderResponse {
    private Long id;
    private LocalDateTime orderDate;
    private String status;
    private String comment;
}
