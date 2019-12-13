package com.tinhpt.order.repository;

import com.tinhpt.order.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentDao extends JpaRepository<DepartmentEntity, Long> {
    
}
