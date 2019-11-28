package com.tinhpt.order.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Data
@Table(name = "season_type")
@EqualsAndHashCode(callSuper=false)
public class SeasonTypeEntity extends BaseEntity {

}
