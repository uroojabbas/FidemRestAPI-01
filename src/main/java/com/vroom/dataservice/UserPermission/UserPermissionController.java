package com.vroom.dataservice.UserPermission;

import com.vroom.dbmodel.orm.Userpermissions;
import com.vroom.dbmodel.orm.Userrole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class UserPermissionController {

    private static final Logger logger = LoggerFactory.getLogger(UserPermissionController.class);

    @Autowired
    UserPermissionService userPermissionService;


    @GetMapping("/userRole/{userId}")
    @ResponseBody
    public Collection<RolePermission> getUserRoleByUserId(@PathVariable int userId){
        logger.debug("gerUserRole By UserId : ");
        return userPermissionService.findByUserId(userId);

    }

    @GetMapping("/userRole")
    @ResponseBody
    public Collection<RolePermission> getUserRoleist(){
        logger.debug("Get User Role List : ");
        return userPermissionService.findAll();

    }
}
