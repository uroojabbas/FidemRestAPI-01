package com.vroom.dataservice.ModulePermission;

import com.vroom.dbmodel.orm.Modules;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ModulePermissionRepository extends CrudRepository<Modules,Long> {

    @Query(value = "Select m.id AS moduleId,m.moduleName AS moduleName, " +
            "mp.id AS permissionTypeId, mp.permissionType AS permissionType  " +
            "From modules m " +
            "INNER JOIN modulepermissions mp " +
            "ON(m.id = mp.moduleId) " +
            "Where m.isdeleted = 0 and mp.isdeleted = 0 " +
            "Order By m.id, mp.id", nativeQuery = true)
    public Set<ModulePermission> getPermissionList();

}
