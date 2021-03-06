package com.tinhpt.order.service;

import com.tinhpt.order.dto.EmployeeCreateRequest;
import com.tinhpt.order.dto.EmployeeResponse;
import com.tinhpt.order.entities.EmployeeEntity;
import com.tinhpt.order.entities.RoleEntity;
import com.tinhpt.order.repository.EmployeeDao;
import com.tinhpt.order.repository.RoleDao;
import com.tinhpt.order.utils.AuditHelper;
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
        return EntityDTOUtils.mapEmployeeEntityToEmployeeDTO(employeeEntity);
    }

    @Override
    public EmployeeResponse findById(Long id) {
        EmployeeEntity employeeEntity = employeeDao.findById(id).orElseThrow(() -> new RuntimeException("Cannot find employee with id=" + id));
        return EntityDTOUtils.mapEmployeeEntityToEmployeeDTO(employeeEntity);
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
}
