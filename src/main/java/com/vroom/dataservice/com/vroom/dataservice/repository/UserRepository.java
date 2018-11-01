package com.vroom.dataservice.com.vroom.dataservice.repository;
import com.vroom.orm.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<Users,Long>{

    Users findById(int id);

    List<Users> findByName(String name);

    List<Users> findAll();

    Users findByUsername(String userName);
}
