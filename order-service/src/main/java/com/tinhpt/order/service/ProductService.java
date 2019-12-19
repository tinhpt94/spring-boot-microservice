package com.tinhpt.order.service;

import com.tinhpt.order.dto.CardDetailResponse;
import com.tinhpt.order.repository.ProductDao;
import com.tinhpt.order.specification.ProductSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<CardDetailResponse> findAll(ProductSpec spec) {
        return productDao.findAll(spec).stream().map(EntityDTOUtils::mapCardDetailEntityToResponse).collect(Collectors.toList());
    }
}
