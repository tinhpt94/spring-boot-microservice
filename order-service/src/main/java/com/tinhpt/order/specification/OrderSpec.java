package com.tinhpt.order.specification;

import com.tinhpt.order.entities.OrderEntity;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

@And({
        @Spec(path = "teleSaleId", params = "teleSaleId", spec = Equal.class),
        @Spec(path = "saleId", params = "saleId", spec = Equal.class),
        @Spec(path = "saleAdminId", params = "saleAdminId", spec = Equal.class),
        @Spec(path = "saleManagerId", params = "saleManagerId", spec = Equal.class),
        @Spec(path = "customer.id", params = "customerId", spec = Equal.class),
        @Spec(path = "cardDetail.id", params = "cardDetailId", spec = Equal.class),
})
public interface OrderSpec extends Specification<OrderEntity> {
}
