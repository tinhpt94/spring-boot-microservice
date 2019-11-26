package com.tinhpt.hr.repositories;

import com.tinhpt.hr.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentDao extends JpaRepository<DepartmentEntity, Long> {
    
}
