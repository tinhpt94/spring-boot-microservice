package com.tinhpt.authservice.repositories;

import com.tinhpt.authservice.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeDao extends JpaRepository<EmployeeEntity, Long> {

    Optional<EmployeeEntity> findByUsernameIgnoreCase(String username);

}
