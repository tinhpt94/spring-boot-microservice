package com.tinhpt.order.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Data
@Table(name = "card_type")
@EqualsAndHashCode(callSuper=false)
public class CardTypeEntity extends BaseEntity {
    private Integer quantity;
}
