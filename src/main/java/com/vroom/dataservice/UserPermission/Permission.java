package com.vroom.dataservice.UserPermission;

public class Permission {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public Permission(String name, int id) {
        this.name = name;
        this.id = id;
    }
}
