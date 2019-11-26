package com.tinhpt.hr.controllers;

import io.swagger.annotations.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DepartmentResponse {
    private Long id;
    private String name;
    private String description;
}
