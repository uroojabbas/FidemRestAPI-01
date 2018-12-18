package com.vroom.dataservice.TransferOrder;

import com.vroom.dbmodel.orm.Tomaster;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransferOrderRepository extends CrudRepository<Tomaster,Long> {

    @Query("SELECT t FROM Tomaster t WHERE (t.isdeleted = false) ")
    List<Tomaster> findAll();

    @Query("SELECT t FROM Tomaster t WHERE t.id = :id AND (t.isdeleted = false)")
    Tomaster findById(@Param("id") int  id);

    @Query("SELECT t.toMaster FROM Todetail t WHERE t.id = :id AND t.toMaster.isdeleted = false")
    Tomaster findByTODetailId(@Param("id") int  id);

}