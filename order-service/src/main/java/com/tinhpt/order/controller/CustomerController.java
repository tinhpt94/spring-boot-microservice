package com.tinhpt.order.controller;

import com.netflix.discovery.converters.Auto;
import com.tinhpt.order.dto.CustomerResponse;
import com.tinhpt.order.dto.OrderResponse;
import com.tinhpt.order.service.ICustomerService;
import com.tinhpt.order.service.IFakerService;
import com.tinhpt.order.service.IOrderService;
import com.tinhpt.order.specification.CustomerSpec;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @Autowired
    private IFakerService fakerService;

    @ApiOperation("Return list of customers")
    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getAllCustomer(CustomerSpec customerSpec) {
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

    @ApiOperation("Fake customer data")
    @PostMapping()
    public ResponseEntity fakeCustomerData() {
        fakerService.fakeCustomerData();
        return ResponseEntity.ok("Create 50 customers");
    }
}
