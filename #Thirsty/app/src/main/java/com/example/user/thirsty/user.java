package com.example.user.thirsty;

/**
 * Created by USER on 2/21/2017.
 */

public class user {
    private String password;
    private String email;
    private final String USER_TYPE = "user";

    public user(String email, String password) {
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
