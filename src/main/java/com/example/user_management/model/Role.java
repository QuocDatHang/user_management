package com.example.user_management.model;

public class Role {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public Role(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
