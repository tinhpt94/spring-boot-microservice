package com.tinhpt.hr.repositories;

import com.tinhpt.hr.entities.DepartmentEntity;
import com.tinhpt.hr.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeDao extends JpaRepository<EmployeeEntity, Long> {

    Optional<EmployeeEntity> findByUsernameIgnoreCase(String username);
    List<EmployeeEntity> findByDepartment(DepartmentEntity departmentEntity);

}
