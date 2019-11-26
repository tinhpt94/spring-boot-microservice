package com.tinhpt.hr.services;

import com.tinhpt.hr.controllers.EmployeeCreateRequest;
import com.tinhpt.hr.controllers.EmployeeResponse;
import org.springframework.web.multipart.MultipartFile;

public interface IEmployeeService {
    Long create(EmployeeCreateRequest createRequest, MultipartFile file);
    EmployeeResponse getCurrentUser();
    EmployeeResponse findById(Long id);
}
