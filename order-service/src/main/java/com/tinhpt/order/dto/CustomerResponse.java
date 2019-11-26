package com.tinhpt.order.dto;

import lombok.Data;

@Data
public class CustomerResponse {
    private Long id;
    private String name;
    private String phone;
    private String address1;
    private String address2;
    private SaleResponse teleSale;
    private SaleResponse sale;
    private SaleResponse saleAdmin;
    private SaleResponse saleManager;
}
