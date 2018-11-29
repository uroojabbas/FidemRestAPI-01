package com.vroom.dataservice.com.vroom.dataservice.repository;

import com.vroom.dbmodel.orm.Pomaster;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PurchaseOrderRepository extends CrudRepository<Pomaster,Long> {

    @Query("SELECT p FROM Pomaster p WHERE (p.isdeleted = false) ")
    List<Pomaster> findAll();

    @Query("SELECT p FROM Pomaster p WHERE p.id = :id AND (p.isdeleted = false)")
    Pomaster findById(@Param("id") int  id);
}

