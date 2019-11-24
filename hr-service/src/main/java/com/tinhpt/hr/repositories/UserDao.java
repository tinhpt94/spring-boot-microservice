package com.tinhpt.hr.repositories;

import com.tinhpt.hr.entities.UserDetailEntity;
import com.tinhpt.hr.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsernameIgnoreCase(String username);

}
