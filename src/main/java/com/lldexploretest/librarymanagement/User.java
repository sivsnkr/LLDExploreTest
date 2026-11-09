package com.lldexploretest.librarymanagement;

public abstract class User {
    private final String name;
    private final String email;
    private final int userId;

    private static int CURRENT_USER_ID = 0;

    public User(String name, String email) {
        this.userId = ++CURRENT_USER_ID;
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getUserId() {
        return userId;
    }
}
