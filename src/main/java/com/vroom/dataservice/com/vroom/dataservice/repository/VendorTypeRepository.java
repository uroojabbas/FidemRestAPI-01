package com.vroom.dataservice.com.vroom.dataservice.repository;

import com.vroom.dbmodel.orm.Vendortype;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VendorTypeRepository extends CrudRepository<Vendortype,Long> {

    @Query("SELECT vt FROM Vendortype vt WHERE (vt.isdeleted = false) ")
    List<Vendortype> findAll();

    @Query("SELECT vt FROM Vendortype vt WHERE vt.type = :type AND (vt.isdeleted = false) ")
    Vendortype findByName(@Param("type") String  type);
}
