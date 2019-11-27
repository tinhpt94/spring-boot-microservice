package com.tinhpt.order.repository;

import com.tinhpt.order.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CustomerDao extends JpaRepository<CustomerEntity, Long>, JpaSpecificationExecutor<CustomerEntity> {

}
