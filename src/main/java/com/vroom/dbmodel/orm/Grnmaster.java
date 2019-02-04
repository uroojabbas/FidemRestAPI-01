package com.vroom.dbmodel.orm;
// Generated Feb 2, 2019 11:12:54 AM by Hibernate Tools 5.2.0.Final


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.persistence.Entity;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Grnmaster generated by hbm2java
 */
@Entity
@Table(name="grnmaster"
    ,catalog="yaqeen"
)
public class Grnmaster  implements java.io.Serializable {


     private Integer id;
     private int userid;
     private Pomaster pomaster;
     private Integer modifiedbyuserid;
     private Date modifiedtime;
     private Date insertedtime;
     private Boolean isdeleted;

    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private Set<Grndetail> grndetail = new HashSet<>(0);

    public Grnmaster() {
    }

	
    public Grnmaster(int userid, Pomaster pomaster) {
        this.userid = userid;
        this.pomaster = pomaster;
    }
    public Grnmaster(int userid, Pomaster pomaster, Integer modifiedbyuserid, Date modifiedtime, Date insertedtime, Boolean isdeleted) {
       this.userid = userid;
       this.pomaster = pomaster;
       this.modifiedbyuserid = modifiedbyuserid;
       this.modifiedtime = modifiedtime;
       this.insertedtime = insertedtime;
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

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy="grnmaster")
    public Set<Grndetail> getGrndetail(){
        return this.grndetail;
    }

    public void setGrndetail(Set<Grndetail> grndetailList){
        this.grndetail = grndetailList;
    }
    
    @Column(name="userid", nullable=false)
    public int getUserid() {
        return this.userid;
    }
    
    public void setUserid(int userid) {
        this.userid = userid;
    }

    
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="poid", nullable=false)
    public Pomaster getPomaster() {
        return this.pomaster;
    }
    
    public void setPomaster(Pomaster pomaster) {
        this.pomaster = pomaster;
    }

    @Column(name="modifiedbyuserid")
    public Integer getModifiedbyuserid() {
        return this.modifiedbyuserid;
    }
    
    public void setModifiedbyuserid(Integer modifiedbyuserid) {
        this.modifiedbyuserid = modifiedbyuserid;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="modifiedtime", length=10)
    public Date getModifiedtime() {
        return this.modifiedtime;
    }
    
    public void setModifiedtime(Date modifiedtime) {
        this.modifiedtime = modifiedtime;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="insertedtime", length=10)
    public Date getInsertedtime() {
        return this.insertedtime;
    }
    
    public void setInsertedtime(Date insertedtime) {
        this.insertedtime = insertedtime;
    }

    
    @Column(name="isdeleted")
    public Boolean getIsdeleted() {
        return this.isdeleted;
    }
    
    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted;
    }

@Transient
public String getGrnId(){
    return "GRN-" + this.getId() + "-" + DateFormatUtils.format(this.getInsertedtime(), "yyyy");
}


}

