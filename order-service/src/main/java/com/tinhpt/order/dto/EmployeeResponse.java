package com.tinhpt.order.dto;

import lombok.Data;

@Data
public class EmployeeResponse {
    private Long id;
    private String username;
    private String name;
    private String address;
    private String imageUrl;
    private String role;
    private String jobTitle;
}
