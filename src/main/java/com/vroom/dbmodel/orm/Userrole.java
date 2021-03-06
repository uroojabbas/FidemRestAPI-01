package com.vroom.dbmodel.orm;
// Generated Apr 25, 2019 12:36:16 AM by Hibernate Tools 5.2.0.Final


import org.hibernate.annotations.GenerationTime;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.*;
import javax.persistence.Entity;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.GenerationType.SEQUENCE;

import java.util.HashSet;
import java.util.Set;

/**
 * Userrole generated by hbm2java
 */
@Entity
@Table(name="userrole"
)
public class Userrole  implements java.io.Serializable {


    private Integer id;

    private Integer roleId;
    private String roleName;
    private Boolean isDeleted;
    private Date insertedtime;
    private Integer insertedbyuserid;
    private Integer modifiedbyuserid;
    private Date modifiedtime;
    private Set<Modulepermissions> modulepermissionses = new HashSet<Modulepermissions>(0);

    public Userrole() {
    }


    public Userrole(String roleName) {
        this.roleName = roleName;
    }
    public Userrole(String roleName, Boolean isDeleted, Date insertedtime, Integer insertedbyuserid, Integer modifiedbyuserid, Date modifiedtime, Set<Modulepermissions> modulepermissionses) {
        this.roleName = roleName;
        this.isDeleted = isDeleted;
        this.insertedtime = insertedtime;
        this.insertedbyuserid = insertedbyuserid;
        this.modifiedbyuserid = modifiedbyuserid;
        this.modifiedtime = modifiedtime;
        this.modulepermissionses = modulepermissionses;
    }

    @Id @GeneratedValue(strategy=IDENTITY)


    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Column(name="roleName", nullable=false, length=50)
    public String getRoleName() {
        return this.roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }


    @Column(name="isDeleted")
    public Boolean getIsDeleted() {
        return this.isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="insertedtime", length=10)
    public Date getInsertedtime() {
        return this.insertedtime;
    }

    public void setInsertedtime(Date insertedtime) {
        this.insertedtime = insertedtime;
    }


    @Column(name="insertedbyuserid")
    public Integer getInsertedbyuserid() {
        return this.insertedbyuserid;
    }

    public void setInsertedbyuserid(Integer insertedbyuserid) {
        this.insertedbyuserid = insertedbyuserid;
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

    @SequenceGenerator(name="seq", initialValue=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    @Column(name = "roleId")
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="rolepermission", catalog="yaqeen", joinColumns = {
            @JoinColumn(name="roleid", nullable=false, updatable=false, referencedColumnName = "roleId") }, inverseJoinColumns = {
            @JoinColumn(name="permissionTypeId", nullable=false, updatable=false) })
    public Set<Modulepermissions> getModulepermissionses() {
        return this.modulepermissionses;
    }

    public void setModulepermissionses(Set<Modulepermissions> modulepermissionses) {
        this.modulepermissionses = modulepermissionses;
    }




}
