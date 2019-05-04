package com.vroom.dataservice.UserRole;

import com.vroom.dbmodel.orm.Userrole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class UserRoleController {

    private static final Logger logger = LoggerFactory.getLogger(UserRoleController.class);

    @Autowired
    UserRoleService userRoleService;

    @GetMapping("/userRoles")
    @ResponseBody
    public Collection<Userrole> getUserRoleList(){
        return this.userRoleService.getUserRoleList();
    }

    @PostMapping(value = "/userRole/save",consumes = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public Userrole save(@RequestBody Userrole userrole){
        logger.debug("save User Role : Name[" + userrole.toString() + "]");
        return this.userRoleService.save(userrole);
    }
}
