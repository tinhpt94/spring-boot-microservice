package com.tinhpt.hr.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@NoArgsConstructor
@Data
@Table(name = "users")
@EqualsAndHashCode(callSuper=false)
public class UserEntity extends AuditEntity {
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
