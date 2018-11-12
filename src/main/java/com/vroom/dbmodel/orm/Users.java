package com.vroom.dbmodel.orm;
// Generated Nov 4, 2018 2:58:54 PM by Hibernate Tools 5.2.0.Final


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
/**
 * Users generated by hbm2java
 */
@Entity
@Table(name="users"
        ,catalog="yaqeen"
        , uniqueConstraints = {@UniqueConstraint(columnNames="name"), @UniqueConstraint(columnNames="username")}
)
public class Users  implements java.io.Serializable {


    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private Integer departmentid;
    private Integer cityid;
    private Integer regionid;
    private Integer gender;
    private Boolean permanent = Boolean.TRUE;
    private Date hiredate;
    private String username;
    private String password;
    private Boolean isdeleted = Boolean.FALSE;

    public Users() {
    }


    public Users(String name, String address, String username) {
        this.name = name;
        this.address = address;
        this.username = username;
    }
    public Users(String name, String email, String phone, String address, Integer departmentid, Integer cityid, Integer regionid, Integer gender, Boolean permanent, Date hiredate, String username, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.departmentid = departmentid;
        this.cityid = cityid;
        this.regionid = regionid;
        this.gender = gender;
        this.permanent = permanent;
        this.hiredate = hiredate;
        this.username = username;
        this.password = password;
    }

    @Id @GeneratedValue(strategy=IDENTITY)


    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Column(name="name", unique=true, nullable=false, length=50)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Column(name="email", length=100)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Column(name="phone", length=56)
    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Column(name="address", nullable=false, length=256)
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Column(name="departmentid")
    public Integer getDepartmentid() {
        return this.departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }


    @Column(name="cityid")
    public Integer getCityid() {
        return this.cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }


    @Column(name="regionid")
    public Integer getRegionid() {
        return this.regionid;
    }

    public void setRegionid(Integer regionid) {
        this.regionid = regionid;
    }


    @Column(name="gender")
    public Integer getGender() {
        return this.gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }


    @Column(name="permanent")
    public Boolean getPermanent() {
        return this.permanent;
    }

    public void setPermanent(Boolean permanent) {
        this.permanent = permanent;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="hiredate", length=10)
    public Date getHiredate() {
        return this.hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }


    @Column(name="username", unique=true, nullable=false, length=256)
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @Column(name="password", length=1024)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name="isdeleted")
    public Boolean getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted;
    }

}


