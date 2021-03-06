package com.vroom.dataservice.UserRole;

import com.vroom.dbmodel.orm.Userrole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Date;

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
        boolean isUserRoleExists = this.isUserRoleExists(userRole.getRoleName());
        if(!isUserRoleExists) {
            userRole.setRoleName(userRole.getRoleName());
            userRole.setInsertedbyuserid(userRole.getInsertedbyuserid());
            userRole.setInsertedtime(new Date());
            userRole.setModifiedbyuserid(null);
            userRole.setModifiedtime(null);
            userRole.setIsDeleted(false);
            if(userRole.getRoleId() == null || userRole.getRoleId() == 0){
                Integer roleId = repository.getMaxRoleId();
                userRole.setRoleId(roleId ==  null ? 1 : roleId + 1);
            }
            userRole = repository.save(userRole);
        }else{

        }
        return userRole;
    }

    private boolean isUserRoleExists(String roleName){
        Userrole userrole = this.repository.findByName(roleName);

        return (userrole == null) ? Boolean.FALSE : Boolean.TRUE;
    }
    public Userrole delete(int id){

        Userrole userRole = repository.findById(id);

        userRole.setIsDeleted(true);

        repository.save(userRole);

        return userRole;
    }

    public Userrole edit(Userrole userRole){



        return repository.save(userRole);

        }



}
