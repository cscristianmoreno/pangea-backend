package com.backend.pangea.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
public class Producers extends BaseEntity {
    private String description;
    private String companyName;
    private String companyDescription;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(referencedColumnName = "id")
    private Users user;

    // @OneToMany(cascade = CascadeType.ALL)
    // @JoinColumn(referencedColumnName = "id")
    // private List<Products> product;
}
