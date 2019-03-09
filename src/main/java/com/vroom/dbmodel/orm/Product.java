package com.vroom.dbmodel.orm;
// Generated Nov 22, 2018 4:34:35 AM by Hibernate Tools 5.2.0.Final


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vroom.dataservice.inventory.TransactionType;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.persistence.Entity;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Product generated by hbm2java
 */
@Entity
@Table(name="product"
    , uniqueConstraints = {@UniqueConstraint(columnNames="isbn"), @UniqueConstraint(columnNames="name")} 
)
public class Product  implements java.io.Serializable {


    private Integer id;
    private Language language;
    private Vendor vendor;
    private String name;
    private String isbn;
    private String author;
    private String subject;
    private String edition;
    private String barcode;
    private String publisher;
    private int countryid;
    private int productcategoryid;
    private int marketsegmentid;
    private Integer pagecount;
    private double productcost;
    private int paperqualityid;
    private double retailprice;
    private Integer userid;
    private Integer modifiedbyuserid;
    private Date modifiedtime;
    private Date insertedtime;
    private Boolean isdeleted;
    private String vendorName;
    private String languagename;


    private int quantity;

    @Transient
    public int getQuantity(){
        return this.quantity;
    }

    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private Set<Inventory> inventory = new HashSet<>(0);

    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private Set<Grndetail> grndetail = new HashSet<>(0);

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy="product")
    @JsonIgnore
    public Set<Grndetail> getGrndetail(){
        return this.grndetail;
    }

    public void setGrndetail(Set<Grndetail> grndetail){
        this.grndetail = grndetail;
    }
    @OneToMany(cascade = CascadeType.ALL,
            mappedBy="product")
    @JsonIgnore
    public Set<Inventory> getInventory(){
        return this.inventory;
    }

    public void setInventory(Set<Inventory> inventory){
        this.inventory = inventory;
    }
    public Product() {
    }


    public Product(Language language, String name, String isbn, String author, String subject, int countryid, int productcategoryid, int marketsegmentid, int paperqualityid) {
        this.language = language;
        this.name = name;
        this.isbn = isbn;
        this.author = author;
        this.subject = subject;
        this.countryid = countryid;
        this.productcategoryid = productcategoryid;
        this.marketsegmentid = marketsegmentid;
        this.paperqualityid = paperqualityid;
    }
    public Product(Language language, Vendor vendor, String name, String isbn, String author, String subject, String edition, String barcode, String publisher, int countryid, int productcategoryid, int marketsegmentid, Integer pagecount, double productcost, int paperqualityid, double retailprice, Integer userid, Integer modifiedbyuserid, Date modifiedtime, Date insertedtime, Boolean isdeleted) {
        this.language = language;
        this.vendor = vendor;
        this.name = name;
        this.isbn = isbn;
        this.author = author;
        this.subject = subject;
        this.edition = edition;
        this.barcode = barcode;
        this.publisher = publisher;
        this.countryid = countryid;
        this.productcategoryid = productcategoryid;
        this.marketsegmentid = marketsegmentid;
        this.pagecount = pagecount;
        this.productcost = productcost;
        this.paperqualityid = paperqualityid;
        this.retailprice = retailprice;
        this.userid = userid;
        this.modifiedbyuserid = modifiedbyuserid;
        this.modifiedtime = modifiedtime;
        this.insertedtime = insertedtime;
        this.isdeleted = isdeleted;
    }

    @Transient
    public String getVendorName(){
        if(this.vendorName == null ||
                this.vendorName.isEmpty()){
            return this.vendor.getName();
        }else{
            return this.vendorName;
        }
    }

    @Transient
    public String getLanguagename(){
        if(this.languagename == null ||
                this.languagename.isEmpty()){
            return this.language.getLanguage();
        }else{
            return this.languagename;
        }
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
    @JoinColumn(name="languageid", nullable=false)
    public Language getLanguage() {
        return this.language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="vendorid")
    public Vendor getVendor() {
        return this.vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }


    @Column(name="name", unique=true, nullable=false, length=50)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Column(name="isbn", unique=true, nullable=false, length=50)
    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    @Column(name="author", nullable=false, length=100)
    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    @Column(name="subject", nullable=false, length=50)
    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


    @Column(name="edition", length=50)
    public String getEdition() {
        return this.edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }


    @Column(name="barcode", length=50)
    public String getBarcode() {
        return this.barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }


    @Column(name="publisher", length=100)
    public String getPublisher() {
        return this.publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }


    @Column(name="countryid", nullable=false)
    public int getCountryid() {
        return this.countryid;
    }

    public void setCountryid(int countryid) {
        this.countryid = countryid;
    }


    @Column(name="productcategoryid", nullable=false)
    public int getProductcategoryid() {
        return this.productcategoryid;
    }

    public void setProductcategoryid(int productcategoryid) {
        this.productcategoryid = productcategoryid;
    }


    @Column(name="marketsegmentid", nullable=false)
    public int getMarketsegmentid() {
        return this.marketsegmentid;
    }

    public void setMarketsegmentid(int marketsegmentid) {
        this.marketsegmentid = marketsegmentid;
    }


    @Column(name="pagecount")
    public Integer getPagecount() {
        return this.pagecount;
    }

    public void setPagecount(Integer pagecount) {
        this.pagecount = pagecount;
    }


    @Column(name="productcost")
    public double getProductcost() {
        return this.productcost;
    }

    public void setProductcost(double productcost) {
        this.productcost = productcost;
    }


    @Column(name="paperqualityid", nullable=false)
    public int getPaperqualityid() {
        return this.paperqualityid;
    }

    public void setPaperqualityid(int paperqualityid) {
        this.paperqualityid = paperqualityid;
    }


    @Column(name="retailprice")
    public double getRetailprice() {
        return this.retailprice;
    }

    public void setRetailprice(double retailprice) {
        this.retailprice = retailprice;
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
    public int getTotalLtdQuantity(){
        return this.getInventory().stream()
                .filter(inventory -> inventory.getTransactionType()
                        != TransactionType.PURCHASE_GENERATED).
                        mapToInt(Inventory::getQuantity).sum();
    }

    @Transient
    public int getOriginalQuantity(){
        return this.getInventory().stream()
                .filter(inventory -> inventory.getTransactionType().
                        equals(TransactionType.PURCHASE_GENERATED)).
                        mapToInt(Inventory::getQuantity).sum();
    }
}


