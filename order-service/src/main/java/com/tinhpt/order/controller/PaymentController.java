package com.tinhpt.order.controller;

import com.tinhpt.order.dto.PaymentResponse;
import com.tinhpt.order.service.IFakerService;
import com.tinhpt.order.service.IPaymentHistoryService;
import com.tinhpt.order.specification.PaymentHistorySpec;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment-histories")
public class PaymentController {

    @Autowired
    private IFakerService fakerService;

    @Autowired
    private IPaymentHistoryService paymentHistoryService;

    @PostMapping
    public ResponseEntity createFakeData() {
        fakerService.fakePaymentData();
        return ResponseEntity.ok("Created 50 payment histories");
    }

    @GetMapping
    public ResponseEntity<Page<PaymentResponse>> findAll(PaymentHistorySpec specs, Pageable pageable) {
        return ResponseEntity.ok(paymentHistoryService.findAll(specs, pageable));
    }
}
