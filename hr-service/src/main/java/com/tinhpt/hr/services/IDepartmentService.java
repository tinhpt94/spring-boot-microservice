package com.tinhpt.hr.services;

import com.tinhpt.hr.controllers.DepartmentResponse;
import com.tinhpt.hr.controllers.EmployeeResponse;

import java.util.List;

public interface IDepartmentService {
    List<DepartmentResponse> findAll();
    List<EmployeeResponse> getEmployeeOfDepartment(Long departmentId);
}
