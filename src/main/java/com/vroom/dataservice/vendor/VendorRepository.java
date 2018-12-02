package com.vroom.dataservice.vendor;

import com.vroom.dbmodel.orm.Vendor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VendorRepository extends CrudRepository<Vendor,Long> {

    @Query("SELECT v FROM Vendor v " +
            " WHERE v.id=:id and (v.isdeleted = false) ")
    Vendor findById(@Param("id") int id);

    @Query("SELECT v FROM Vendor v " +
            " WHERE v.name=:name and (v.isdeleted = false) ")
    Vendor findByName(@Param("name") String name);

    @Query("SELECT v FROM Vendor v " +
            " WHERE  (v.isdeleted = false) ")
    List<Vendor> findAll();

}
