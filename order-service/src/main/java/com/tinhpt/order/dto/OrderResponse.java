package com.tinhpt.order.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderResponse {
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
