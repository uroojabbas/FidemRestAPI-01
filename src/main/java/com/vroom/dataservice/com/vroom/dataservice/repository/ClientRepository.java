package com.vroom.dataservice.com.vroom.dataservice.repository;

import com.vroom.dbmodel.orm.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client,Long> {

    @Query("SELECT c FROM Client c WHERE (c.isdeleted = false) ")
    List<Client> findAll();

    @Query("SELECT c FROM Client c WHERE c.name = :name AND (c.isdeleted = false) ")
    List<Client> findByName(@Param("name") String  name);

    @Query("SELECT c FROM Client c WHERE c.id = :id AND (c.isdeleted = false) ")
    Client findById(@Param("id") int  id);
}
