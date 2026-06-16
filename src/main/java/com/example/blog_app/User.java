package com.example.blog_app;

public class User {
    private final Long id;
    private final String userName;
    private final String passwordHash;
    public User(Long id, String userName, String passworsHash){
        this.id = id;
        this.userName = userName;
        this.passwordHash = passworsHash;
    }
    public Long getId() {
        return id;
    }
    public String getPasswordHash() {
        return passwordHash;
    }
    public String getUserName() {
        return userName;
    }
}
