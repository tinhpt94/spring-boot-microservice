package com.tinhpt.order.service;

import com.github.javafaker.Faker;
import com.tinhpt.order.entities.CardDetailEntity;
import com.tinhpt.order.entities.CustomerEntity;
import com.tinhpt.order.entities.OrderEntity;
import com.tinhpt.order.repository.CardDetailDao;
import com.tinhpt.order.repository.CustomerDao;
import com.tinhpt.order.repository.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
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
            entity.setCustomer(customerDao.findById(Long.valueOf(faker.random().nextInt(1000, 1049))).get());
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
            entity.setTeleSaleId(Long.valueOf(faker.random().nextInt(1000, 1049)));
            entity.setSaleId(Long.valueOf(faker.random().nextInt(1050, 1099)));
            entity.setSaleAdminId(Long.valueOf(faker.random().nextInt(1100, 1149)));
            entity.setSaleManagerId(Long.valueOf(faker.random().nextInt(1150, 1199)));
            int statusInt = faker.random().nextInt(0, 100);
            entity.setStatus(statusInt < 30 ? "CANCEL" : statusInt < 60 ? "PAYING" : "PAID");
            orderDao.save(entity);
        }
    }
}
