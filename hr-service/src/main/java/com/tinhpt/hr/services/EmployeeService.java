package com.tinhpt.hr.services;

import com.tinhpt.hr.controllers.EmployeeCreateRequest;
import com.tinhpt.hr.controllers.EmployeeResponse;
import com.tinhpt.hr.entities.EmployeeEntity;
import com.tinhpt.hr.entities.RoleEntity;
import com.tinhpt.hr.repositories.EmployeeDao;
import com.tinhpt.hr.repositories.RoleDao;
import com.tinhpt.hr.utils.AuditHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private IFileUpload fileUpload;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public Long create(EmployeeCreateRequest createRequest, MultipartFile file) {
        String uploadedUrl = fileUpload.uploadFile(createRequest.getName(), file);
        EmployeeEntity employeeEntity = employeeDao.save(mapModelToEmployeeEntity(createRequest, uploadedUrl));
        return employeeEntity.getId();
    }

    @Override
    public EmployeeResponse getCurrentUser() {
        String username = AuditHelper.getCurrentAuditor();
        EmployeeEntity employeeEntity = employeeDao.findByUsernameIgnoreCase(username).orElseThrow(() -> new RuntimeException("Cannot find username: " + username));
        return convertEntityToDetailResponse(employeeEntity);
    }


    private EmployeeEntity mapModelToEmployeeEntity(EmployeeCreateRequest createRequest, String imageUrl) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setUsername(createRequest.getUsername());
        RoleEntity roleEntity = roleDao.findByNameIgnoreCase(createRequest.getRole()).orElseThrow(() -> new RuntimeException("Invalid Role"));
        employeeEntity.setRole(roleEntity);
        employeeEntity.setEncryptedPassword(encoder.encode("12345"));
        employeeEntity.setAddress(createRequest.getAddress());
        employeeEntity.setName(createRequest.getName());
        employeeEntity.setImageUrl(imageUrl);
        employeeEntity.setDob(createRequest.getDob());
        return employeeEntity;
    }

    private EmployeeResponse convertEntityToDetailResponse(EmployeeEntity employeeEntity) {
        EmployeeResponse response = new EmployeeResponse();
        response.setAddress(employeeEntity.getAddress());
        response.setImageUrl(employeeEntity.getImageUrl());
        response.setName(employeeEntity.getName());
        response.setUsername(employeeEntity.getUsername());
        response.setRole(employeeEntity.getRole().getName());
        response.setJobTitle(employeeEntity.getRole().getJobTitle());
        return response;
    }
}
