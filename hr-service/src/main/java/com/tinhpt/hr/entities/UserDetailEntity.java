package com.tinhpt.hr.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
@Table(name = "user_detail")
@EqualsAndHashCode(callSuper=false)
public class UserDetailEntity extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank(message = "Name must not be blank")
    private String name;

    private LocalDateTime dob;

    private String address;

    @Column(name = "image_url")
    private String imageUrl;

    @OneToOne
    @NotNull
    private UserEntity user;
}
