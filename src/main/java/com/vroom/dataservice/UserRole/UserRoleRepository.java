package com.vroom.dataservice.UserRole;

import com.vroom.dbmodel.orm.Userrole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface  UserRoleRepository extends CrudRepository<Userrole,Long> {
    @Query("SELECT ur FROM Userrole ur WHERE ur.isDeleted = false ")
    List<Userrole> findAll();

    @Query("SELECT ur FROM Userrole ur WHERE ur.id = :id AND (ur.isDeleted = false) ")
    Userrole findById(@Param("id") int  id);

    @Query("SELECT ur FROM Userrole ur WHERE ur.roleName = :roleName AND (ur.isDeleted = false) ")
    Userrole findByName(@Param("roleName") String  roleName);

    @Query("SELECT MAX(ur.roleId) FROM Userrole ur")
    Integer getMaxRoleId();
}
