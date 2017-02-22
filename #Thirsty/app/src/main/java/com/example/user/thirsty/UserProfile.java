package com.example.user.thirsty;

/**
 * Created by USER on 2/21/2017.
 */

public abstract class UserProfile {

    abstract String getPassword();
    abstract String getEmail();
    abstract String getUserType();
    abstract void setPassword(String password);
    abstract void setEmail(String email);

}
