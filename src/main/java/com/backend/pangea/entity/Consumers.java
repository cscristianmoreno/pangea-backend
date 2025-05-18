package com.backend.pangea.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
public class Consumers extends BaseEntity {
    private String description;

    // @OneToOne
    // @JoinColumn(referencedColumnName = "id")
    // private Services service;
    
    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    private Users user; 
}
