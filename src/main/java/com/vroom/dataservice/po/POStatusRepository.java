package com.vroom.dataservice.po;

import com.vroom.dbmodel.orm.Pomaster;
import com.vroom.dbmodel.orm.Postatus;
import com.vroom.dbmodel.orm.Postatustype;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface POStatusRepository extends CrudRepository<Postatus,Long> {

    @Query("SELECT p FROM Postatus p WHERE (p.pomaster.isdeleted = false) ")
    List<Postatus> findAll();

    @Query("SELECT p FROM Postatus p WHERE p.id = :id AND (p.pomaster.isdeleted = false)")
    Postatus findById(@Param("id") int  id);

    @Query("SELECT p.pomaster FROM Postatus p WHERE p.pomaster.vendor.id = :vendorId AND (p.pomaster.isdeleted = false)" +
            "AND p.postatusType.id IN (2, 3)")

    Set<Pomaster> findByVendorId(@Param("vendorId") int  vendorId);
}
