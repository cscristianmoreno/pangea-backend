package com.backend.pangea.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString(callSuper = true)
public class Administrators extends BaseEntity {
    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    private Users user;
}
