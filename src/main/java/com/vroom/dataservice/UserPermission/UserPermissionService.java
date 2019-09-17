package com.vroom.dataservice.UserPermission;

import com.vroom.dataservice.UserRole.UserRoleRepository;
import com.vroom.dataservice.com.vroom.dataservice.repository.UserRepository;
import com.vroom.dbmodel.orm.Userpermissions;
import com.vroom.dbmodel.orm.Userrole;
import com.vroom.dbmodel.orm.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserPermissionService {
    private static final Logger logger = LoggerFactory.getLogger(UserPermissionService.class);

    @Autowired
    UserPermissionRepository userPermissionRepository;
    @Autowired
    UserRoleRepository userRoleRepository;
    @Autowired
    UserRepository userRepository;


    public Collection<RolePermission> findAll() {
        Collection<Userrole> userRoleList =  userRoleRepository.findAll();
        return this.getRolePermission(userRoleList, new ArrayList(0));

    }

    private Collection<RolePermission> getRolePermission(Collection<Userrole> roleList,
                                                         Collection<Userrole> userRoleList) {
        Collection<RolePermission> rolePermissionList = new ArrayList(0);
        for(Userrole userRole :roleList){

            RolePermission rolePermission = new RolePermission();
            if(userRoleList.contains(userRole)) {
                rolePermission.setRoleAssignToUser(Boolean.TRUE);
            } else {
                rolePermission.setRoleAssignToUser(Boolean.FALSE);
            }
            rolePermission.setName(userRole.getRoleName());
            rolePermission.setId(userRole.getRoleId());
            userRole.getModulepermissionses().forEach(modulepermissions -> rolePermission.addPermission(modulepermissions.getPermissionType(), modulepermissions.getId()));
            rolePermissionList.add(rolePermission);
        }

        return rolePermissionList;
    }


    public Collection<RolePermission> findByUserId(int userId) {
        Collection<Userrole> roleList = userRoleRepository.findAll();
        Collection<Userrole> userRoleList = userPermissionRepository.findByUserId(userId);
        return this.getRolePermission(roleList, userRoleList);
    }

    public void save(List<Integer> userRole, int forUserId, int fromUserId) {

        Collection<Userrole> userRoleList = new ArrayList(0);
        for(Integer roleId : userRole) {
            if(userRoleList.isEmpty()) {
                userRoleList = userPermissionRepository.findByUserId(forUserId);
            }
            Userrole uRole = userRoleList.stream()
                    .filter(role -> role.getRoleId().equals(roleId))
                    .findAny()
                    .orElse(null);

            if(uRole == null) {
                this.saveUserRole(forUserId, roleId, fromUserId);
            }
        }


    }

    private void saveUserRole(Number userId, Number roleId, Integer fromUserId) {
        Userrole userRole = userRoleRepository.findById(roleId.intValue());
        Users user = userRepository.findById(userId);

        Userpermissions userpermissions = new Userpermissions(userRole,
                user,
                Boolean.FALSE,
                new Date(),
                fromUserId,
                fromUserId,
                new Date());

        this.userPermissionRepository.save(userpermissions);

    }
}
