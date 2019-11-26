package com.tinhpt.authservice.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@NoArgsConstructor
@Data
@Table(name = "employee")
@EqualsAndHashCode(callSuper=false)
public class EmployeeEntity extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank(message = "Username must not be blank")
    @Column(unique = true)
    private String username;

    @NotEmpty(message = "Encrypted password must not be empty")
    private String encryptedPassword;

    @ManyToOne
    @NotNull
    private RoleEntity role;
}
