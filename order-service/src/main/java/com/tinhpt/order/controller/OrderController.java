package com.tinhpt.order.controller;

import com.tinhpt.order.dto.OrderResponse;
import com.tinhpt.order.dto.PaymentResponse;
import com.tinhpt.order.service.IFakerService;
import com.tinhpt.order.service.IOrderService;
import com.tinhpt.order.service.IPaymentHistoryService;
import com.tinhpt.order.specification.OrderSpec;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @Autowired
    private IPaymentHistoryService paymentHistoryService;

    @Autowired
    private IFakerService fakerService;

    @GetMapping
    public ResponseEntity<Page<OrderResponse>> find(OrderSpec orderSpec, Pageable pageable) {
        return ResponseEntity.ok(orderService.findAll(orderSpec, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(orderService.findById(id));
    }

    @GetMapping("/{id}/payment-histories")
    public ResponseEntity<List<PaymentResponse>> findPaymentByOrderId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(paymentHistoryService.findPaymentHistoryByOrderId(id));
    }

    @PostMapping
    public ResponseEntity fakeOrder() {
        fakerService.fakeOrderData();
        return ResponseEntity.ok("Created");
    }

}
