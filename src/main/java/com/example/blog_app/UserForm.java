package com.example.blog_app;

public class UserForm {
    private final String userName;
    private final String password;

    public UserForm(String userName, String password){
        this.userName = userName;
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public String getUserName() {
        return userName;
    }
}
