package com.vroom.dataservice.UserPermission;

import java.util.ArrayList;
import java.util.Collection;

public class RolePermission {

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

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
