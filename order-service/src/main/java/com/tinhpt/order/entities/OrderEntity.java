package com.tinhpt.order.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
@Table(name = "orders")
@EqualsAndHashCode(callSuper=false)
public class OrderEntity extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private LocalDateTime date;
    private String status;
    private String comment;

    @ManyToOne
    private CustomerEntity customer;

    @ManyToOne
    private EmployeeEntity teleSale;

    @ManyToOne
    private EmployeeEntity sale;

    @ManyToOne
    private EmployeeEntity saleAdmin;

    @ManyToOne
    private EmployeeEntity saleManager;

    private Integer discount;
    private Long contractValue;
    private Long contractValueVat;

    @ManyToOne
    private CardDetailEntity cardDetail;
}
