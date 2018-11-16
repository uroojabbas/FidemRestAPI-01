package com.vroom.dbmodel.orm;
// Generated Nov 15, 2018 11:07:58 PM by Hibernate Tools 5.2.0.Final


import org.apache.tomcat.util.buf.StringUtils;

import javax.persistence.*;
import javax.persistence.Entity;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Vendor generated by hbm2java
 */
@Entity
@Table(name="vendor"
        ,catalog="yaqeen"
        , uniqueConstraints = @UniqueConstraint(columnNames="name")
)
public class Vendor  extends AbstractEntity {


    private Integer id;
    private Vendortype vendortype;
    private String name;
    private String address;
    private String email;
    private String contactperson;
    private String contactone;
    private String contactpersontwo;
    private String contacttwo;
    private String ntn;
    private String strn;
    private Integer discount;
    private Integer paymentterms;
    private Boolean isdeleted;

    @Transient
    private String type;

    public Vendor() {
    }


    public Vendor(String name, String address, String contactperson, String contactone, String contactpersontwo, String contacttwo) {
        this.name = name;
        this.address = address;
        this.contactperson = contactperson;
        this.contactone = contactone;
        this.contactpersontwo = contactpersontwo;
        this.contacttwo = contacttwo;
    }
    public Vendor(Vendortype vendortype, String name, String address, String email, String contactperson, String contactone, String contactpersontwo, String contacttwo, String ntn, String strn, Integer discount, Integer paymentterms, Boolean isdeleted) {
        this.vendortype = vendortype;
        this.name = name;
        this.address = address;
        this.email = email;
        this.contactperson = contactperson;
        this.contactone = contactone;
        this.contactpersontwo = contactpersontwo;
        this.contacttwo = contacttwo;
        this.ntn = ntn;
        this.strn = strn;
        this.discount = discount;
        this.paymentterms = paymentterms;
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
    @JoinColumn(name="vendortypeid")
    public Vendortype getVendortype() {
        return this.vendortype;
    }

    public void setVendortype(Vendortype vendortype) {
        this.vendortype = vendortype;
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


    @Column(name="contactperson", nullable=false, length=50)
    public String getContactperson() {
        return this.contactperson;
    }

    public void setContactperson(String contactperson) {
        this.contactperson = contactperson;
    }


    @Column(name="contactone", nullable=false, length=50)
    public String getContactone() {
        return this.contactone;
    }

    public void setContactone(String contactone) {
        this.contactone = contactone;
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


    @Column(name="ntn", length=30)
    public String getNtn() {
        return this.ntn;
    }

    public void setNtn(String ntn) {
        this.ntn = ntn;
    }


    @Column(name="strn", length=30)
    public String getStrn() {
        return this.strn;
    }

    public void setStrn(String strn) {
        this.strn = strn;
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


    @Column(name="isdeleted")
    public Boolean getIsdeleted() {
        return this.isdeleted;
    }

    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted == null ? Boolean.FALSE : isdeleted;
    }

    @Transient
    public String getType(){
        if(this.type == null || this.type.isEmpty()) {
            return this.vendortype.getType();
        }else{
            return this.type;
        }
    }


}
