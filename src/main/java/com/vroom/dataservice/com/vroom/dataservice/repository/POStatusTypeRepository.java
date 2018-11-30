package com.vroom.dataservice.com.vroom.dataservice.repository;

import com.vroom.dbmodel.orm.Postatustype;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface POStatusTypeRepository extends CrudRepository<Postatustype,Long> {

    @Query("SELECT l FROM Postatustype l WHERE (l.isdeleted = false OR l.isdeleted = 'false') ")
    List<Postatustype> findAll();

    Postatustype findById(int id);

    @Query("SELECT l FROM Postatustype l WHERE l.name = :name and (l.isdeleted = false OR l.isdeleted = 'false') ")
    Postatustype findByLanguage(@Param("name") String name);

}
