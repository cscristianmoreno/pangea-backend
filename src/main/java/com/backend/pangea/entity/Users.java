package com.backend.pangea.entity;
import java.util.List;

import com.backend.pangea.enums.UserRole;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import lombok.Data;
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
