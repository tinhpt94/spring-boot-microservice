package com.tinhpt.order.dto;

import lombok.Data;

@Data
public class CardDetailResponse extends BaseResponse {
    private Long unitPrice;
    private Long annualFee;
    private Long reSignFee;

    private CardTypeResponse cardType;

    private BaseResponse roomType;

    private BaseResponse seasonType;
}
