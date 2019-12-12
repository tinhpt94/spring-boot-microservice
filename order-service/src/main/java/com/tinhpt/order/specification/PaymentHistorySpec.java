package com.tinhpt.order.specification;

import com.tinhpt.order.entities.PaymentHistoryEntity;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.GreaterThanOrEqual;
import net.kaczmarzyk.spring.data.jpa.domain.LessThanOrEqual;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

@And({
        @Spec(path = "date", params = "startDate", spec = GreaterThanOrEqual.class),
        @Spec(path = "date", params = "endDate", spec = LessThanOrEqual.class),
        @Spec(path = "type", params = "type", spec = Equal.class),
        @Spec(path = "status", params = "status", spec = Equal.class),
})
public interface PaymentHistorySpec extends Specification<PaymentHistoryEntity> {
}
