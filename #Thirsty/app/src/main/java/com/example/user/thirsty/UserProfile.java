package com.example.user.thirsty;

/**
 * Created by Dennis Eddington on 2/21/2017.
 * @author Dennis Eddington
 */


public abstract class UserProfile {

    abstract String getPassword();
    abstract String getEmail();
    abstract String getUserType();
    abstract void setPassword(String password);
    abstract void setEmail(String email);

}
