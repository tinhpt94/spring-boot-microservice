package com.tinhpt.order.controller;

import com.tinhpt.order.dto.CustomerResponse;
import com.tinhpt.order.dto.OrderResponse;
import com.tinhpt.order.service.ICustomerService;
import com.tinhpt.order.service.IOrderService;
import com.tinhpt.order.specification.CustomerSpec;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api
@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IOrderService orderService;

    @ApiOperation("Return list of customers")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "teleSaleId", value = "Tele Sale Id", dataType = "long", example = "1", paramType = "query"),
            @ApiImplicitParam(name = "saleId", value = "Sale Id", dataType = "long", example = "2", paramType = "query"),
            @ApiImplicitParam(name = "saleAdminId", value = "Sale Admin Id", dataType = "long", example = "3", paramType = "query"),
            @ApiImplicitParam(name = "saleManagerId", value = "Sale Manager Id", dataType = "long", example = "4", paramType = "query")
    })
    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getAllCustomer(@ApiParam CustomerSpec customerSpec) {
        return ResponseEntity.ok(customerService.getAllCustomer(customerSpec));
    }

    @ApiOperation("Return a customer")
    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(customerService.findById(id));
    }

    @ApiOperation("Return list orders of customer")
    @GetMapping("/{id}/orders")
    public ResponseEntity<List<OrderResponse>> findOrderByCustomerId(@PathVariable("id") Long customerId) {
        return ResponseEntity.ok(orderService.findOrderByCustomerId(customerId));
    }
}
