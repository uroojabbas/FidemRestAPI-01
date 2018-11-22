package com.vroom.dataservice.com.vroom.dataservice.repository;

import com.vroom.dbmodel.orm.Designation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DesignationRepository extends CrudRepository<Designation,Long> {

    @Query("SELECT d FROM Designation d WHERE (d.isdeleted = false) ")
    List<Designation> findAll();

    @Query("SELECT d FROM Designation d WHERE d.name = :name AND (d.isdeleted = false) ")
    Designation findByName(@Param("name") String  name);
}
