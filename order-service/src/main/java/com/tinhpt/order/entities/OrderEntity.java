package com.tinhpt.order.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
@Table(name = "order")
@EqualsAndHashCode(callSuper=false)
public class OrderEntity extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private LocalDateTime orderDate;

    private String status;

    private String comment;

    @ManyToOne
    private CustomerEntity customer;
}
