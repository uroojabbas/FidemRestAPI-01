package com.vroom.dataservice.UserRole;

import com.vroom.dbmodel.orm.Userrole;
import com.vroom.dbmodel.orm.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Collection;
import java.util.Date;

import com.vroom.dbmodel.orm.Users;

@Service
public class UserRoleService {
    @Autowired
    UserRoleRepository repository;

    private static final Logger logger = LoggerFactory.getLogger(UserRoleService.class);

    public Collection<Userrole> getUserRoleList() {
        return repository.findAll();
    }

    public Userrole getUserrolebyid(int id){
        logger.debug("getUserRole : [" + id + "]");
        return repository.findById(id);

    }

    /**
     * To persist user role object into DB
     * @param userRole
     * @return
     */
    public Userrole save(Userrole userRole) {
        logger.debug("save User Role : Name[" + userRole.toString() + "]");

        userRole.setRoleName(userRole.getRoleName());
        userRole.setId(userRole.getId());
        userRole=repository.save(userRole);
        userRole.setInsertedtime(new Date());
        return userRole;
    }

    public Userrole delete(Userrole userRole){

        userRole.setIsDeleted(true);

        return userRole;
    }

    public Userrole edit(Userrole userRole){

        userRole.getModifiedtime();
        userRole.setIsDeleted(true);
        userRole=repository.save(userRole);
        userRole.setId(null);
        userRole.setModifiedtime(new Date());
        return userRole;
    }



}
