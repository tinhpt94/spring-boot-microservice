package com.tinhpt.order.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@Table(name = "customer")
@EqualsAndHashCode(callSuper=false)
public class CustomerEntity extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private String phone;
    private String address1;
    private String address2;
    private Long teleSaleId;
    private Long saleId;
    private Long saleAdminId;
    private Long saleManagerId;
}
