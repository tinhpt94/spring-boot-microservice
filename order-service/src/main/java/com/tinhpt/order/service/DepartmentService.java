package com.tinhpt.order.service;

import com.tinhpt.order.dto.DepartmentResponse;
import com.tinhpt.order.dto.EmployeeResponse;
import com.tinhpt.order.entities.DepartmentEntity;
import com.tinhpt.order.repository.DepartmentDao;
import com.tinhpt.order.repository.EmployeeDao;
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
        return departmentDao.findAll().stream().map(EntityDTOUtils::mapDepartmentEntityToDTO).collect(Collectors.toList());
    }

    @Override
    public List<EmployeeResponse> getEmployeeOfDepartment(Long departmentId) {
        DepartmentEntity departmentEntity = departmentDao.findById(departmentId).orElseThrow(() -> new RuntimeException("Cannot find department " + departmentId));
        return employeeDao.findByDepartment(departmentEntity).stream().map(EntityDTOUtils::mapEmployeeEntityToEmployeeDTO).collect(Collectors.toList());
    }
}
