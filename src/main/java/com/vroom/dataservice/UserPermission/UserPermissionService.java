package com.vroom.dataservice.UserPermission;

import com.vroom.dataservice.UserRole.UserRoleRepository;
import com.vroom.dbmodel.orm.Userrole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserPermissionService {
    private static final Logger logger = LoggerFactory.getLogger(UserPermissionService.class);

    @Autowired
    UserPermissionRepository userPermissionRepository;
    @Autowired
    UserRoleRepository userRoleRepository;

    public Collection<RolePermission> findAll() {
        Collection<Userrole> userRoleList =  userRoleRepository.findAll();
        return this.getRolePermission(userRoleList);

    }

    private Collection<RolePermission> getRolePermission(Collection<Userrole> userRoleList) {
        Collection<RolePermission> rolePermissionList = new ArrayList(0);
        for(Userrole userRole :userRoleList){
            RolePermission rolePermission = new RolePermission();
            rolePermission.setName(userRole.getRoleName());
            rolePermission.setId(userRole.getId());
            userRole.getModulepermissionses().forEach(modulepermissions -> rolePermission.addPermission(modulepermissions.getPermissionType(), modulepermissions.getId()));
            rolePermissionList.add(rolePermission);
        }

        return rolePermissionList;
    }


    public Collection<RolePermission> findByUserId(int userId) {
        Collection<Userrole> userRoleList = userPermissionRepository.findByUserId(userId);
        return this.getRolePermission(userRoleList);
    }
}
