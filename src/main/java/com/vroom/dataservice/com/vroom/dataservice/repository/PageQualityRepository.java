package com.vroom.dataservice.com.vroom.dataservice.repository;

import com.vroom.dbmodel.orm.PaperQuality;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PageQualityRepository extends CrudRepository<PaperQuality,Long> {

    @Query("SELECT pq FROM PaperQuality pq WHERE (pq.isdeleted = false OR pq.isdeleted = 'false') ")
    List<PaperQuality> findAll();

    PaperQuality findById(int id);


    @Query("SELECT pq FROM PaperQuality pq WHERE pq.name=:name AND (pq.isdeleted = false OR pq.isdeleted = 'false') ")
    PaperQuality findByName(@Param("name") String name);
}
