package com.example.blog_app;

public class User {
    private final Long id;
    private final String userName;
    private final String passwordHash;
    public User(Long id, String userName, String passwordHash){
        this.id = id;
        this.userName = userName;
        this.passwordHash = passwordHash;
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
