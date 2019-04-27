package com.vroom.dataservice.UserRole;

import com.vroom.dbmodel.orm.Userrole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface  UserRoleRepository extends CrudRepository<Userrole,Long> {
    @Query("SELECT ur FROM Userrole ur WHERE ur.isDeleted = false ")
    List<Userrole> findAll();
}
