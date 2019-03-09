package com.vroom.dbmodel.orm;
// Generated Nov 3, 2018 3:28:54 AM by Hibernate Tools 5.2.0.Final


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * City generated by hbm2java
 */
@Entity
@Table(name="city")
public class City  implements java.io.Serializable {


     private Integer id;
     private String cityname;
     private Boolean isdeleted;

    public City() {
    }

	
    public City(String cityname) {
        this.cityname = cityname;
    }
    public City(String cityname, Boolean isdeleted) {
       this.cityname = cityname;
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

    
    @Column(name="cityname", nullable=false, length=128)
    public String getCityname() {
        return this.cityname;
    }
    
    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    
    @Column(name="isdeleted")
    public Boolean getIsdeleted() {
        return this.isdeleted;
    }
    
    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted;
    }




}


