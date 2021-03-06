package com.tinhpt.order.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EmployeeCreateRequest {
    private String name;
    private String address;
    private String role;
    private String username;
    private LocalDateTime dob;
}
