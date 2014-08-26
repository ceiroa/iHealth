package com.ceiroa.model;

public class User {

    private long id;
    private String username;
    private UserType userType;   //admin or nonadmin
    private String email;
    private String password;
    private Status status;

    public User() { }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
    public boolean isAdmin() {
        if(this.userType==userType.admin)
            return true;
        return false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public UserType getUserType() {
        return this.userType;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserType(UserType usertype) {
        this.userType = usertype;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}