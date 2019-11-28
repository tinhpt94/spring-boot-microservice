package com.tinhpt.order.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Data
@Table(name = "room_type")
@EqualsAndHashCode(callSuper=false)
public class RoomTypeEntity extends BaseEntity{

}
