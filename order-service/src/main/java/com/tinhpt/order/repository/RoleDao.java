package com.tinhpt.order.repository;

import com.tinhpt.order.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleDao extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findByNameIgnoreCase(String name);
}
