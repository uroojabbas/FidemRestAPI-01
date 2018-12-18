package com.vroom.dataservice.TransferOrder;

import com.vroom.dbmodel.orm.Tomaster;
import com.vroom.dbmodel.orm.Tostatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface TransferOrderStatusRepository extends CrudRepository<Tostatus,Long> {

    @Query("SELECT t FROM Tostatus t WHERE (t.toMaster.isdeleted = false) ")
    List<Tostatus> findAll();

    @Query("SELECT p FROM Tostatus p WHERE p.id = :id AND (p.toMaster.isdeleted = false)")
    Tostatus findById(@Param("id") int  id);

    @Query("SELECT t.toMaster FROM Tostatus t WHERE (t.toMaster.isdeleted = false) " +
            " AND t.tostatusType.id IN :toStatusTypeList AND t.isactive = true")
    Set<Tomaster> findByStatusId(@Param("toStatusTypeList") List<Integer> toStatusTypeList);
}