package com.vroom.dataservice.UserPermission;

import java.util.List;

public class UserRoleDTO {
    private int forUserId;
    private List<Integer> userRoles;
    private int fromUserId;


    public int getForUserId() {
        return this.forUserId;
    }

    public int getFromUserId() {
        return this.fromUserId;
    }

    public List<Integer> getUserRoles(){
        return this.userRoles;
    }
}
