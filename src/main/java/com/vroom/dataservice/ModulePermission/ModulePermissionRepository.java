package com.vroom.dataservice.ModulePermission;

import com.vroom.dbmodel.orm.Modules;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ModulePermissionRepository extends CrudRepository<Modules,Long> {

    @Query("SELECT m FROM Modules m Where (m.isdeleted = false) ")
    public Set<Modules> getPermissionList();
}
