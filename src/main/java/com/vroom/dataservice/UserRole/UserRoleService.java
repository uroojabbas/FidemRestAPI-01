package com.vroom.dataservice.UserRole;

import com.vroom.dbmodel.orm.Userrole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserRoleService {
    @Autowired
    UserRoleRepository repository ;

    public Collection<Userrole> getUserRoleList(){
        return this.repository.findAll();
    }
}
