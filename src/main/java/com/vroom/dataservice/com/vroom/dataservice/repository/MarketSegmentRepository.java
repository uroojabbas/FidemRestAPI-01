package com.vroom.dataservice.com.vroom.dataservice.repository;

import com.vroom.dbmodel.orm.Marketsegment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MarketSegmentRepository extends CrudRepository<Marketsegment,Long> {

    @Query("SELECT ms FROM Marketsegment ms WHERE (ms.isdeleted = false OR ms.isdeleted = 'false') ")
    List<Marketsegment> findAll();

    Marketsegment findById(int id);


    @Query("SELECT ms FROM Marketsegment ms WHERE ms.name=:name AND (ms.isdeleted = false OR ms.isdeleted = 'false') ")
    Marketsegment findByName(@Param("name") String name);
}