package com.broderieDor.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
 
    @Enumerated(EnumType.STRING)
    @Column(length = 60)
    private RoleName name;
 
    //Constructors
    public Role() {}

    
    public Role(RoleName name) {
        this.name = name;
    }
 
    //GETTERS - SETTERS
    public long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public RoleName getName() {
        return name;
    }
 
    public void setName(RoleName name) {
        this.name = name;
    }
}
