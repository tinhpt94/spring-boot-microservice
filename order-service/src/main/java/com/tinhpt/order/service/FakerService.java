package com.tinhpt.order.service;

import com.github.javafaker.Faker;
import com.tinhpt.order.entities.*;
import com.tinhpt.order.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FakerService implements IFakerService {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private CardDetailDao cardDetailDao;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private PaymentHistoryDao paymentHistoryDao;

    private Faker faker = new Faker();

    @Override
    public void fakeCustomerData() {
        for (int i = 0; i < 50; i++) {
            CustomerEntity entity = new CustomerEntity();
            entity.setName(faker.name().fullName());
            entity.setPhone(faker.phoneNumber().cellPhone());
            entity.setAddress1(faker.address().fullAddress());
            entity.setAddress2(faker.address().fullAddress());
            customerDao.save(entity);
        }
    }

    @Override
    public void fakeOrderData() {
        for (int i = 0; i < 50; i++) {
            OrderEntity entity = new OrderEntity();
            entity.setCustomer(customerDao.findById(Long.valueOf(faker.random().nextInt(1200, 1299))).get());
            CardDetailEntity cardDetailEntity = cardDetailDao.findById(Long.valueOf(faker.random().nextInt(7, 14))).get();
            entity.setCardDetail(cardDetailEntity);
            entity.setContractValueVat(cardDetailEntity.getUnitPrice() * cardDetailEntity.getCardType().getQuantity() * 7);
            entity.setContractValue(cardDetailEntity.getUnitPrice() * cardDetailEntity.getCardType().getQuantity() * 70 / 11);
            entity.setDate(
                    LocalDateTime.of(2019,
                            faker.random().nextInt(1, 12),
                            faker.random().nextInt(1, 28),
                            faker.random().nextInt(0, 23),
                            faker.random().nextInt(0, 59))
            );
            entity.setDiscount(faker.random().nextInt(0, 7));
            entity.setTeleSale(employeeDao.findById(Long.valueOf(faker.random().nextInt(1000, 1049))).get());
            entity.setSale(employeeDao.findById(Long.valueOf(faker.random().nextInt(1050, 1099))).get());
            entity.setSaleAdmin(employeeDao.findById(Long.valueOf(faker.random().nextInt(1100, 1149))).get());
            entity.setSaleManager(employeeDao.findById(Long.valueOf(faker.random().nextInt(1150, 1199))).get());
            int statusInt = faker.random().nextInt(0, 100);
            entity.setStatus(statusInt < 30 ? "CANCEL" : statusInt < 60 ? "PAYING" : "PAID");
            orderDao.save(entity);
        }
    }

    @Override
    public void fakePaymentData() {
        for (int i = 0; i < 50; i++) {
            PaymentHistoryEntity paymentHistoryEntity = new PaymentHistoryEntity();
            paymentHistoryEntity.setDate(
                    LocalDateTime.of(2019,
                            faker.random().nextInt(1, 12),
                            faker.random().nextInt(1, 28),
                            faker.random().nextInt(0, 23),
                            faker.random().nextInt(0, 59))
            );
            OrderEntity orderEntity = orderDao.findById(Long.valueOf(faker.random().nextInt(1300, 1399))).get();
            Long paymentValue = faker.random().nextLong(orderEntity.getContractValue());
            paymentHistoryEntity.setValue(paymentValue);
            paymentHistoryEntity.setValueVat((long) (paymentValue * 1.1));
            paymentHistoryEntity.setOrder(orderEntity);
            int status = faker.random().nextInt(0, 100);
            paymentHistoryEntity.setType(status < 30 ? "Tiền mặt" : status < 60 ? "Chuyển khoản" : "Thẻ ghi nợ");
            paymentHistoryEntity.setStatus(status < 30 ? "Tạo khoản thu" : status < 60 ? "Kiểm tra khoản thu" : "Xác nhận khoản thu");
            paymentHistoryDao.save(paymentHistoryEntity);
        }
    }

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private DepartmentDao departmentDao;

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
            entity.setDob(LocalDateTime.of(
                    faker.random().nextInt(1970, 2000),
                    faker.random().nextInt(1, 12),
                    faker.random().nextInt(1, 28),
                    faker.random().nextInt(0, 23),
                    faker.random().nextInt(0, 59)));
            entity.setEncryptedPassword(encoder.encode("12345"));
            employeeDao.save(entity);
        }
    }
}
