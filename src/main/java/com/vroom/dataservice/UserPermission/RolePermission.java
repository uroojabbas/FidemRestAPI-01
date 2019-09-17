package com.vroom.dataservice.UserPermission;

import java.util.ArrayList;
import java.util.Collection;

public class RolePermission {

    private String name;
    private boolean roleAssignToUser;


    public int getId() {
        return id;
    }

    public boolean isRoleAssignToUser() {
        return roleAssignToUser;
    }

    public void setRoleAssignToUser(boolean roleAssignToUser) {
        this.roleAssignToUser = roleAssignToUser;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    private int userId;




    public Collection<Permission> getModulepermissionses() {
        return modulepermissionses;
    }

    public void setPermission(Collection<Permission> permission) {
        this.modulepermissionses = permission;
    }

    private Collection<Permission> modulepermissionses = new ArrayList(0);

    public String getName() {
        return name;
    }

    public void setName(String roleName) {
        this.name = roleName;
    }

    public void addPermission(String permissionName, int id) {
        modulepermissionses.add(new Permission(permissionName,id));
    }
}
