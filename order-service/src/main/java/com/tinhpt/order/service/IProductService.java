package com.tinhpt.order.service;

import com.tinhpt.order.dto.CardDetailResponse;
import com.tinhpt.order.specification.ProductSpec;

import java.util.List;

public interface IProductService {
    List<CardDetailResponse> findAll(ProductSpec spec);
}
