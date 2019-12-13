package com.tinhpt.order.service;

import com.tinhpt.order.dto.EmployeeCreateRequest;
import com.tinhpt.order.dto.EmployeeResponse;
import org.springframework.web.multipart.MultipartFile;

public interface IEmployeeService {
    Long create(EmployeeCreateRequest createRequest, MultipartFile file);
    EmployeeResponse getCurrentUser();
    EmployeeResponse findById(Long id);
}
