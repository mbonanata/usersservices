package com.despegar.cgp.model;

public class User {

    private String id;

    private String name;

    private String group;

    public User(String id, String name, String group) {
        this.id = id;
        this.name = name;
        this.group = group;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }
}
