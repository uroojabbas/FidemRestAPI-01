package com.vroom.dataservice.com.vroom.dataservice.repository;

import com.vroom.dbmodel.orm.Clienttype;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientTypeRepository  extends CrudRepository<Clienttype,Long> {

    @Query("SELECT ct FROM Clienttype ct WHERE (ct.isdeleted = false) ")
    List<Clienttype> findAll();

    @Query("SELECT ct FROM Clienttype ct WHERE ct.type = :type AND (ct.isdeleted = false) ")
    Clienttype findByName(@Param("type") String  type);
}
