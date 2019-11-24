package com.tinhpt.hr.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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

    @NotNull
    private Integer number;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoleEntity)) return false;
        if (!super.equals(o)) return false;
        RoleEntity that = (RoleEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, name, number);
    }
}
