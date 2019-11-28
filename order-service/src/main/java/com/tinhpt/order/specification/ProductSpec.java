package com.tinhpt.order.specification;

import com.tinhpt.order.entities.CardDetailEntity;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Conjunction;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Or;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

@Conjunction({
        @Or({
                @Spec(path = "cardType.id", params = "cardTypeId", spec = Equal.class),
                @Spec(path = "cardType.name", params = "cardTypeName", spec = Equal.class),
        }),
        @Or({
                @Spec(path = "seasonType.id", params = "seasonTypeId", spec = Equal.class),
                @Spec(path = "seasonType.name", params = "seasonTypeName", spec = Equal.class),
        }),
        @Or({
                @Spec(path = "roomType.id", params = "roomTypeId", spec = Equal.class),
                @Spec(path = "roomType.name", params = "roomTypeName", spec = Equal.class),
        })

})
public interface ProductSpec extends Specification<CardDetailEntity> {
}
