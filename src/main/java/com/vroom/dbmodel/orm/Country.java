package com.vroom.dbmodel.orm;
// Generated Nov 20, 2018 10:37:48 PM by Hibernate Tools 5.2.0.Final


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Country generated by hbm2java
 */
@Entity
@Table(name="country")
public class Country  implements java.io.Serializable {


     private Integer id;
     private String country;

    @Column(name="countrycode", nullable=false, length=2)
    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    private String countrycode;
     private Boolean isdeleted;

    public Country() {
    }

	
    public Country(String country) {
        this.country = country;
    }
    public Country(String country, Boolean isdeleted) {
       this.country = country;
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

    
    @Column(name="country", nullable=false, length=50)
    public String getCountry() {
        return this.country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }

    
    @Column(name="isdeleted")
    public Boolean getIsdeleted() {
        return this.isdeleted;
    }
    
    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted;
    }




}


