package com.tinhpt.order.service;

import com.tinhpt.order.dto.DepartmentResponse;
import com.tinhpt.order.dto.EmployeeResponse;

import java.util.List;

public interface IDepartmentService {
    List<DepartmentResponse> findAll();
    List<EmployeeResponse> getEmployeeOfDepartment(Long departmentId);
}
