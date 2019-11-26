package com.tinhpt.hr.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


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

    @NotBlank(message = "Name must not be blank")
    private String name;

    private LocalDateTime dob;

    private String address;

    @Column(name = "image_url")
    private String imageUrl;

    @ManyToOne
    @NotNull
    private RoleEntity role;

    @ManyToOne
    private DepartmentEntity department;
}
