package com.tinhpt.order.controller;

import com.tinhpt.order.service.IFakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment-histories")
public class PaymentController {

    @Autowired
    private IFakerService fakerService;

    @PostMapping
    public ResponseEntity createFakeData() {
        fakerService.fakePaymentData();
        return ResponseEntity.ok("Created 50 payment histories");
    }
}
