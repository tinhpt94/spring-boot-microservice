package com.tinhpt.order.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InComeReport {
    private Long orderId;
    private Long value;
    private Long valueVat;
}
