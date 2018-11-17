package com.vroom.dataservice.com.vroom.dataservice.repository;

import com.vroom.dbmodel.orm.Institutetype;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InstituteTypeRepository extends CrudRepository<Institutetype,Long> {

    @Query("SELECT it FROM Institutetype it WHERE (it.isdeleted = false) ")
    List<Institutetype> findAll();

    @Query("SELECT it FROM Institutetype it WHERE it.type = :type AND (it.isdeleted = false) ")
    Institutetype findByName(@Param("type") String  type);
}
