package com.tinhpt.order.repository;

import com.tinhpt.order.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<CustomerEntity, Long> {

}
