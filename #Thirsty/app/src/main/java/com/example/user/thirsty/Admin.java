package com.example.user.thirsty;

/**
 * Created by USER on 2/21/2017.
 */

public class Admin extends UserProfile {
    private String password;
    private String email;
    private String userType;

    public Admin(String email, String password, String userType) {
        this.password = password;
        this.email = email;
        this.userType = userType;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getUserType() {
        return userType;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
