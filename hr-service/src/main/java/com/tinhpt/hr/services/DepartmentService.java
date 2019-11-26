package com.tinhpt.hr.services;

import com.tinhpt.hr.controllers.DepartmentResponse;
import com.tinhpt.hr.controllers.EmployeeResponse;
import com.tinhpt.hr.entities.DepartmentEntity;
import com.tinhpt.hr.entities.EmployeeEntity;
import com.tinhpt.hr.repositories.DepartmentDao;
import com.tinhpt.hr.repositories.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService implements IDepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<DepartmentResponse> findAll() {
        return departmentDao.findAll().stream().map(this::convertEntityToModel).collect(Collectors.toList());
    }

    @Override
    public List<EmployeeResponse> getEmployeeOfDepartment(Long departmentId) {
        DepartmentEntity departmentEntity = departmentDao.findById(departmentId).orElseThrow(() -> new RuntimeException("Cannot find department " + departmentId));
        return employeeDao.findByDepartment(departmentEntity).stream().map(this::convertEntityToDetailResponse).collect(Collectors.toList());
    }

    private DepartmentResponse convertEntityToModel(DepartmentEntity entity) {
        return new DepartmentResponse(entity.getId(), entity.getName(), entity.getDescription());
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
