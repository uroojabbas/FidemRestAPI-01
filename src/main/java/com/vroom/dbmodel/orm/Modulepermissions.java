package com.vroom.dbmodel.orm;
// Generated Apr 23, 2019 8:20:19 AM by Hibernate Tools 5.2.0.Final


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Modulepermissions generated by hbm2java
 */
@Entity
@Table(name="modulepermissions")
public class Modulepermissions  implements java.io.Serializable {


     private Integer id;
     private Modules module;
     private String permissionType;
     private boolean isdeleted;

    public Modulepermissions() {
    }

    public Modulepermissions(Modules module, String permissionType, boolean isdeleted) {
       this.module = module;
       this.permissionType = permissionType;
       this.isdeleted = isdeleted;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="moduleId", nullable=false)
    @JsonIgnore
    public Modules getModule() {
        return this.module;
    }
    
    public void setModule(Modules module) {
        this.module = module;
    }

    
    @Column(name="permissionType", nullable=false, length=50)
    public String getPermissionType() {
        return this.permissionType;
    }
    
    public void setPermissionType(String permissionType) {
        this.permissionType = permissionType;
    }

    
    @Column(name="isdeleted", nullable=false)
    public boolean isIsdeleted() {
        return this.isdeleted;
    }
    
    public void setIsdeleted(boolean isdeleted) {
        this.isdeleted = isdeleted;
    }
}

