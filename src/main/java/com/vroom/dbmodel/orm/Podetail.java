package com.vroom.dbmodel.orm;
// Generated Nov 28, 2018 9:06:06 PM by Hibernate Tools 5.2.0.Final


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vroom.dataservice.inventory.TransactionType;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.persistence.Entity;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Podetail generated by hbm2java
 */
@Entity
@Table(name="podetail")
public class Podetail  implements java.io.Serializable {


    private Integer id;
    private Pomaster pomaster;
    private Product product;
    private Integer quantity;

    public Podetail() {
    }

    public Podetail(Pomaster pomaster, Product product, Integer quantity) {
        this.pomaster = pomaster;
        this.product = product;
        this.quantity = quantity;
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
    @JoinColumn(name="poid", nullable=false)
    @JsonIgnore
    public Pomaster getPomaster() {
        return this.pomaster;
    }

    public void setPomaster(Pomaster pomaster) {
        this.pomaster = pomaster;
    }


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="productid", nullable=false)
    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


    @Column(name="quantity")
    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Transient
    public double getTotalAmount(){
        return this.quantity * this.product.getProductcost();
    }

}
