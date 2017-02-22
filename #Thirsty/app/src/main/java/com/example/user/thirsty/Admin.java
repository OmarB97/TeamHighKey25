package com.example.user.thirsty;

/**
 * Created by USER on 2/21/2017.
 */

public class Admin {
    private String password;
    private String email;
    private final String ADMIN_TYPE = "Admin";

    public Admin(String email, String password) {
        this.password = password;
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
