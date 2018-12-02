package com.vroom.dataservice.po;

import com.vroom.dbmodel.orm.Postatustype;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface POStatusTypeRepository extends CrudRepository<Postatustype,Long> {

    @Query("SELECT pst FROM Postatustype pst WHERE (pst.isdeleted = false OR pst.isdeleted = 'false') ")
    List<Postatustype> findAll();

    Postatustype findById(int id);

    @Query("SELECT pst FROM Postatustype pst WHERE pst.name = :name and (pst.isdeleted = false OR pst.isdeleted = 'false') ")
    Postatustype findByStatus(@Param("name") String name);

}
