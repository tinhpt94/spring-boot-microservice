package com.tinhpt.hr.controllers;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserCreateRequest {
    private String name;
    private String address;
    private String role;
    private String username;
    private LocalDateTime dob;
}
