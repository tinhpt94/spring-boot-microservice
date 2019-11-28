package com.tinhpt.order.service;

import com.tinhpt.order.dto.CardDetailResponse;
import com.tinhpt.order.dto.CardTypeResponse;
import com.tinhpt.order.dto.RoomTypeResponse;
import com.tinhpt.order.dto.SeasonTypeResponse;
import com.tinhpt.order.entities.CardDetailEntity;
import com.tinhpt.order.repository.ProductDao;
import com.tinhpt.order.specification.ProductSpec;
import org.springframework.beans.BeanUtils;
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
        return productDao.findAll(spec).stream().map(this::mapEntityToResponse).collect(Collectors.toList());
    }

    private CardDetailResponse mapEntityToResponse(CardDetailEntity entity) {
        CardDetailResponse response = new CardDetailResponse();
        BeanUtils.copyProperties(entity, response);
        CardTypeResponse cardTypeResponse = new CardTypeResponse();
        BeanUtils.copyProperties(entity.getCardType(), cardTypeResponse);
        response.setCardType(cardTypeResponse);
        SeasonTypeResponse seasonTypeResponse = new SeasonTypeResponse();
        BeanUtils.copyProperties(entity.getSeasonType(), seasonTypeResponse);
        response.setSeasonType(seasonTypeResponse);
        RoomTypeResponse roomTypeResponse = new RoomTypeResponse();
        BeanUtils.copyProperties(entity.getRoomType(), roomTypeResponse);
        response.setRoomType(roomTypeResponse);
        return response;
    }
}
