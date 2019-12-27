package com.tinhpt.order.controller;

import com.tinhpt.order.dto.CommissionResponse;
import com.tinhpt.order.service.ICommissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/commission-report")
public class CommissionController {

    @Autowired
    private ICommissionService commissionService;

    @GetMapping
    public List<CommissionResponse> getCommissionReport(
            @RequestParam(name = "startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(name = "endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return commissionService.getCommissionReport(startDate.atStartOfDay(), endDate.atTime(23,59,59));
    }
}
