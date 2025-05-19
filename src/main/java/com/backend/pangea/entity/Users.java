package com.backend.pangea.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
public class Users extends BaseEntity {
    private String name;

    private String email;
    private String password;
    private String phone;
    private String memberState;
    private String buyerDirection;
    private String sellerDirection;

    @Transient
    private Producers producer;

    @Transient
    private Consumers consumer;

    @Transient
    private Administrators administrator;


}
