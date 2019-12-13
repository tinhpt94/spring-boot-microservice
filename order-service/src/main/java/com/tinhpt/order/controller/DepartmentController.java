package com.tinhpt.order.controller;

import com.tinhpt.order.dto.DepartmentResponse;
import com.tinhpt.order.dto.EmployeeResponse;
import com.tinhpt.order.service.IDepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments")
@Api("Department API")
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;

    @ApiOperation("Return list of department")
    @GetMapping
    public ResponseEntity<List<DepartmentResponse>> findAll() {
        List<DepartmentResponse> departments = departmentService.findAll();
        return ResponseEntity.ok(departments);
    }

    @ApiOperation("Return employee of department")
    @GetMapping("{departmentId}/employees")
    public ResponseEntity<List<EmployeeResponse>> getEmployeeOfDepartment(@PathVariable(value = "departmentId") Long departmentId) {
        List<EmployeeResponse> employees = departmentService.getEmployeeOfDepartment(departmentId);
        return ResponseEntity.ok(employees);
    }
}
