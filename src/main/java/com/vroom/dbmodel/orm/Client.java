package com.vroom.dbmodel.orm;
// Generated Nov 17, 2018 5:55:35 PM by Hibernate Tools 5.2.0.Final


import java.util.Date;
import javax.persistence.*;
import javax.persistence.Entity;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Client generated by hbm2java
 */
@Entity
@Table(name="client"
    ,catalog="yaqeen"
    , uniqueConstraints = @UniqueConstraint(columnNames="name") 
)
public class Client  {


     private Integer id;
     private City city;
     private Clienttype clienttype;
     private Institutetype institutetype;
     private Region region;
     private String name;
     private String address;
     private String email;
     private String principlename;
     private String contact;
     private String contactpersontwo;
     private String contacttwo;
     private Integer totalbranches;
     private Integer strenght;
     private Integer discount;
     private Integer paymentterms;
     private Integer userid;
     private Integer modifiedbyuserid;
     private Date modifiedtime;
     private Boolean isdeleted;
     private String area;
     private int clientstaus;

    @Transient
    private String cityname;

    @Transient
    private String regionname;


    @Transient
    private String institutetypename;

    @Transient
    private String clienttypename;


    @Column(name="area", length=100)
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Transient
    public String getInstitutetypename() {
        if(this.institutetypename == null ||
                this.institutetypename.isEmpty()){
            return this.institutetype.getType();
        }else {
            return institutetypename;
        }
    }

    @Transient
    public String getClienttypename() {

        if(this.clienttypename == null || this.clienttypename.isEmpty()){
            return this.clienttype.getType();
        }else {
            return clienttypename;
        }
    }



     @Transient
    public String getCityname() {

         if(this.cityname == null || this.cityname.isEmpty())
         {
             return this.city.getCityname();
         }else {
             return this.cityname;
         }
    }




    @Transient
    public String getRegionname() {
         if(this.regionname == null || this.regionname.isEmpty()){
             return this.region.getRegionname();

         }else {
             return this.regionname;
         }
    }


    public Client() {
    }

	
    public Client(String name, String address, String principlename, String contact) {
        this.name = name;
        this.address = address;
        this.principlename = principlename;
        this.contact = contact;
    }
    public Client(City city, Clienttype clienttype, Institutetype institutetype, Region region, String name, String address, String email, String principlename, String contact, String contactpersontwo, String contacttwo, Integer totalbranches, Integer strenght, Integer discount, Integer paymentterms, Integer userid, Integer modifiedbyuserid, Date modifiedtime, Boolean isdeleted) {
       this.city = city;
       this.clienttype = clienttype;
       this.institutetype = institutetype;
       this.region = region;
       this.name = name;
       this.address = address;
       this.email = email;
       this.principlename = principlename;
       this.contact = contact;
       this.contactpersontwo = contactpersontwo;
       this.contacttwo = contacttwo;
       this.totalbranches = totalbranches;
       this.strenght = strenght;
       this.discount = discount;
       this.paymentterms = paymentterms;
       this.userid = userid;
       this.modifiedbyuserid = modifiedbyuserid;
       this.modifiedtime = modifiedtime;
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
    @JoinColumn(name="cityid")
    public City getCity() {
        return this.city;
    }
    
    public void setCity(City city) {
        this.city = city;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="clienttypeid")
    public Clienttype getClienttype() {
        return this.clienttype;
    }
    
    public void setClienttype(Clienttype clienttype) {
        this.clienttype = clienttype;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="instituetypeid")
    public Institutetype getInstitutetype() {
        return this.institutetype;
    }
    
    public void setInstitutetype(Institutetype institutetype) {
        this.institutetype = institutetype;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="regionid")
    public Region getRegion() {
        return this.region;
    }
    
    public void setRegion(Region region) {
        this.region = region;
    }

    
    @Column(name="name", unique=true, nullable=false, length=50)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="address", nullable=false, length=50)
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    
    @Column(name="email", length=100)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="principlename", nullable=false, length=50)
    public String getPrinciplename() {
        return this.principlename;
    }
    
    public void setPrinciplename(String principlename) {
        this.principlename = principlename;
    }

    
    @Column(name="contact", nullable=false, length=50)
    public String getContact() {
        return this.contact;
    }
    
    public void setContact(String contact) {
        this.contact = contact;
    }

    
    @Column(name="contactpersontwo", length=50)
    public String getContactpersontwo() {
        return this.contactpersontwo;
    }
    
    public void setContactpersontwo(String contactpersontwo) {
        this.contactpersontwo = contactpersontwo;
    }

    
    @Column(name="contacttwo", length=50)
    public String getContacttwo() {
        return this.contacttwo;
    }
    
    public void setContacttwo(String contacttwo) {
        this.contacttwo = contacttwo;
    }

    
    @Column(name="totalbranches")
    public Integer getTotalbranches() {
        return this.totalbranches;
    }
    
    public void setTotalbranches(Integer totalbranches) {
        this.totalbranches = totalbranches;
    }

    
    @Column(name="strenght")
    public Integer getStrenght() {
        return this.strenght;
    }
    
    public void setStrenght(Integer strenght) {
        this.strenght = strenght;
    }

    
    @Column(name="discount")
    public Integer getDiscount() {
        return this.discount;
    }
    
    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    
    @Column(name="paymentterms")
    public Integer getPaymentterms() {
        return this.paymentterms;
    }
    
    public void setPaymentterms(Integer paymentterms) {
        this.paymentterms = paymentterms;
    }

    
    @Column(name="userid")
    public Integer getUserid() {
        return this.userid;
    }
    
    public void setUserid(Integer userid) {
        this.userid = userid;
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

    
    @Column(name="isdeleted")
    public Boolean getIsdeleted() {
        return this.isdeleted;
    }
    
    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted == null ? Boolean.FALSE : isdeleted;
    }


    @Column(name="clientstaus")
    public int getClientstaus() {
        return clientstaus;
    }

    public void setClientstaus(int clientstaus) {
        this.clientstaus = clientstaus;
    }
}


