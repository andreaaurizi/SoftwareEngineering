package com.mycompany.lab2client;

public class User {
    private static User instance = new User();
    private String user = null;
    
    private User() {}
    
    public static final User getInstance(){
        return instance;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
