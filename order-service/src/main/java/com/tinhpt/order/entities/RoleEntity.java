package com.tinhpt.order.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@NoArgsConstructor
@Data
@Table(name = "role")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank(message = "Role name must not be blank")
    @Column(unique = true)
    private String name;

    @Column(name = "job_title")
    @NotNull
    private String jobTitle;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoleEntity)) return false;
        if (!super.equals(o)) return false;
        RoleEntity that = (RoleEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, name);
    }
}
