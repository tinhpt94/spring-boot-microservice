package com.tinhpt.order.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PaymentResponse {
    private Long id;
    private LocalDateTime date;
    private Long value;
    private Long valueVat;
    private String comment;
    private String type;
}
