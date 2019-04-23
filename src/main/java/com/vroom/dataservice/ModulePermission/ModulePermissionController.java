package com.vroom.dataservice.ModulePermission;

import com.vroom.dbmodel.orm.Modules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ModulePermissionController {

    private static final Logger logger = LoggerFactory.getLogger(ModulePermissionController.class);

    @Autowired
    ModulePermissionService modulePermissionService;

    @GetMapping("/modulePermissions")
    @ResponseBody
    public Collection<Modules> getProductById(){
        logger.debug("getModulePermissionList : [ ALL]");
        return modulePermissionService.getModulePermissionList();

    }
}
