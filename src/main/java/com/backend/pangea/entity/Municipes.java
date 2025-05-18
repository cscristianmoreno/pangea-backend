package com.backend.pangea.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
public class Municipes extends BaseEntity {
    private String name;
    private String phone;
    private String location;
    private String personInCharge;
    private String logisticInCharge;
    private String logisticPhone;
    private String productDeposit;
}
