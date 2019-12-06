package com.tinhpt.hr.services;

import com.github.javafaker.Faker;
import com.netflix.discovery.converters.Auto;
import com.tinhpt.hr.entities.DepartmentEntity;
import com.tinhpt.hr.entities.EmployeeEntity;
import com.tinhpt.hr.entities.RoleEntity;
import com.tinhpt.hr.repositories.DepartmentDao;
import com.tinhpt.hr.repositories.EmployeeDao;
import com.tinhpt.hr.repositories.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FakerService implements IFakerService {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private DepartmentDao departmentDao;

    private Faker faker = new Faker();

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public void createTeleSale() {
        RoleEntity roleEntity = roleDao.findByNameIgnoreCase("TELE_SALE").get();
        createFakeEmployee(roleEntity);
    }

    @Override
    public void createSale() {
        RoleEntity roleEntity = roleDao.findByNameIgnoreCase("SALE").get();
        createFakeEmployee(roleEntity);
    }

    @Override
    public void createSaleAdmin() {
        RoleEntity roleEntity = roleDao.findByNameIgnoreCase("SALE_ADMIN").get();
        createFakeEmployee(roleEntity);
    }

    @Override
    public void createSaleManager() {
        RoleEntity roleEntity = roleDao.findByNameIgnoreCase("SALE_MANAGER").get();
        createFakeEmployee(roleEntity);
    }

    private void createFakeEmployee(RoleEntity roleEntity) {
        DepartmentEntity departmentEntity = departmentDao.findById(8L).get();
        for (int i = 0; i < 50; i++) {
            EmployeeEntity entity = new EmployeeEntity();
            entity.setName(faker.name().fullName());
            entity.setUsername(faker.name().username() + "@crystal-holiday.com");
            entity.setDepartment(departmentEntity);
            entity.setRole(roleEntity);
            entity.setAddress(faker.address().fullAddress());
            //entity.setDob(LocalDateTime.parse(faker.date().birthday().toString()));
            entity.setEncryptedPassword(encoder.encode("12345"));
            employeeDao.save(entity);
        }
    }
}
