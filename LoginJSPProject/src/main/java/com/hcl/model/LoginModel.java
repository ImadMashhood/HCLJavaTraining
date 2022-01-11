package com.hcl.model;

public class LoginModel {

    //Initialize Variables
    private String userName = " ";
    private String password = " ";

    //Getters
    public String getUsername() {
        return userName;
    }
    public String getPassword() {
        return password;
    }

    //Setters
    public void setUsername(String userName) {
        this.userName = userName;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    //Validation
    public boolean validateLogin() {
        return (userName.equals("imad") && password.equals("test"));
    }
}