package com.tinhpt.order.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
@Table(name = "order_detail")
@EqualsAndHashCode(callSuper=false)
public class OrderDetailEntity extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Long productId;

    private LocalDateTime depositDate;

    private Long contractValue;

    private Long contractValueVat;

    @ManyToOne
    private OrderEntity order;
}
