package com.tinhpt.order.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Data
@Table(name = "card_detail")
@EqualsAndHashCode(callSuper=false)
public class CardDetailEntity extends BaseEntity{

    private Long unitPrice;
    private Long annualFee;
    private Long reSignFee;

    @ManyToOne
    private CardTypeEntity cardType;

    @ManyToOne
    private RoomTypeEntity roomType;

    @ManyToOne
    private SeasonTypeEntity seasonType;
}
