package com.tinhpt.order.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderResponse {
    private Long id;

    private LocalDateTime date;
    private String status;
    private String comment;

    private SaleResponse teleSale;
    private SaleResponse sale;
    private SaleResponse saleAdmin;
    private SaleResponse saleManager;
    private Integer discount;
    private Long contractValue;
    private Long contractValueVat;
    private String cardName;
}
