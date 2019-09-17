package com.vroom.dataservice.UserPermission;

import com.vroom.dbmodel.orm.Userpermissions;
import com.vroom.dbmodel.orm.Userrole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;

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

    @GetMapping("/userRole/userRoleList/{userId}")
    @ResponseBody
    public Collection<RolePermission> getUserRoleist(@PathVariable int userId){
        logger.debug("Get User Role List : ");
        return userPermissionService.findAll();

    }

    @PostMapping(value = "/userRoles/add_update",consumes = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public boolean addUpdate(@RequestBody UserRoleDTO userRoleDTO){
        logger.debug("Add/Update User Role ");

        this.userPermissionService.save(userRoleDTO.getUserRoles(), userRoleDTO.getForUserId(), userRoleDTO.getFromUserId());
        return true;
    }
}
