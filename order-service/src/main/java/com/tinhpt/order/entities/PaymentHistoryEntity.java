package com.tinhpt.order.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
@Table(name = "payment_history")
@EqualsAndHashCode(callSuper=false)
public class PaymentHistoryEntity extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private LocalDateTime date;

    private Long value;

    private Long valueVat;

    private String comment;

    private String type;

    @ManyToOne
    private OrderEntity order;
}
