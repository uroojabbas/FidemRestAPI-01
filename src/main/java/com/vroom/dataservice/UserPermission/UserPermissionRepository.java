package com.vroom.dataservice.UserPermission;

import com.vroom.dbmodel.orm.Userpermissions;
import com.vroom.dbmodel.orm.Userrole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface UserPermissionRepository extends CrudRepository<Userpermissions,Long> {

    @Query("SELECT up.userrole FROM Userpermissions up WHERE up.users.id = :userId")
    Collection<Userrole> findByUserId(@Param("userId") Number  userId);

    @Query("SELECT up.userrole FROM Userpermissions up")
    Collection<Userrole> findAllUserRole();
}
