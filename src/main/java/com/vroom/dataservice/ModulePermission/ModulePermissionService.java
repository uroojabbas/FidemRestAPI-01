package com.vroom.dataservice.ModulePermission;

import com.vroom.dbmodel.orm.Modules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ModulePermissionService {

    @Autowired
    ModulePermissionRepository modulePermissionRepository;

    public Collection<ModulePermission> getModulePermissionList(){
        return modulePermissionRepository.getPermissionList();
    }
}
