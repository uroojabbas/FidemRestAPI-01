package com.vroom.dataservice.com.vroom.dataservice.repository;
import com.vroom.dbmodel.orm.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<Users,Long>{

    @Query("SELECT u FROM Users u WHERE u.id=:id and (u.isdeleted = false OR u.isdeleted = 'false') ")
    Users findById(@Param("id") int id);

    List<Users> findByName(String name);

    @Query("SELECT u FROM Users u WHERE (u.isdeleted = false OR u.isdeleted = 'false') ")
    List<Users> findAll();


    Users findByUsername(String userName);

}
