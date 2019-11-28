package com.tinhpt.order.controller;

import com.tinhpt.order.dto.OrderResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/orders")
public class OrderController {

    @GetMapping
    public ResponseEntity<List<OrderResponse>> find() {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> findById(@PathVariable("id") Long id) {
        return null;
    }

    @GetMapping("/{id}/order-details")
    public ResponseEntity<OrderResponse> findOrderDetail(@PathVariable("id") Long id) {
        return null;
    }

    @GetMapping("/{orderId}/order-details/{orderDetailId}")
    public ResponseEntity<OrderResponse> findOrderDetail(@PathVariable("orderId") Long orderId, @PathVariable("orderDetailId") Long orderDetailId) {
        return null;
    }
}
