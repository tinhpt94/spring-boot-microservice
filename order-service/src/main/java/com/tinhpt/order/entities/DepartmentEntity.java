package com.tinhpt.order.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@NoArgsConstructor
@Data
@Table(name = "department")
public class DepartmentEntity extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank(message = "Name must not be blank")
    private String name;

    private String description;
}
