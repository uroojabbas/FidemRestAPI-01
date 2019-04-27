package com.vroom.dataservice.UserRole;

import com.vroom.dbmodel.orm.Userrole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class UserRoleController {
    @Autowired
    UserRoleService userRoleService;

    @GetMapping("/userRoles")
    @ResponseBody
    public Collection<Userrole> getUserRoleList(){
        return this.userRoleService.getUserRoleList();
    }

}
