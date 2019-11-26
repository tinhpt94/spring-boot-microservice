package com.tinhpt.hr.controllers;

import lombok.Data;

@Data
public class EmployeeResponse {
    private String username;
    private String name;
    private String address;
    private String imageUrl;
    private String role;
    private String jobTitle;
}
