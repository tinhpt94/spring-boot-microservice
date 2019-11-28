package com.tinhpt.order.controller;

import com.tinhpt.order.dto.CardDetailResponse;
import com.tinhpt.order.service.IProductService;
import com.tinhpt.order.specification.ProductSpec;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @ApiOperation("Return list of products")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cardTypeId", value = "Id kiểu thẻ", dataType = "long", example = "1", paramType = "query"),
            @ApiImplicitParam(name = "cardTypeName", value = "Loại thẻ", dataType = "string", example = "50 năm", paramType = "query"),
            @ApiImplicitParam(name = "roomTypeId", value = "Id phòng ngủ", dataType = "long", example = "1", paramType = "query"),
            @ApiImplicitParam(name = "roomTypeName", value = "Phòng ngủ", dataType = "string", example = "01 phòng ngủ", paramType = "query"),
            @ApiImplicitParam(name = "seasonTypeId", value = "Id season", dataType = "long", example = "1", paramType = "query"),
            @ApiImplicitParam(name = "seasonTypeName", value = "Season", dataType = "string", example = "Mùa thấp điểm", paramType = "query"),
    })
    @GetMapping
    public ResponseEntity<List<CardDetailResponse>> findAll(ProductSpec productSpec) {
        return ResponseEntity.ok(productService.findAll(productSpec));
    }
}
