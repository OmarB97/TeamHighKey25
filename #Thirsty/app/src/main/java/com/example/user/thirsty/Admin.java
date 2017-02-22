package com.example.user.thirsty;

/**
 * Created by USER on 2/21/2017.
 */

public class Admin extends UserProfile {
    private String password;
    private String email;
    private String userType;

    /**
     *
     * @param email
     * @param password
     * @param userType
     */
    public Admin(String email, String password, String userType) {
        this.password = password;
        this.email = email;
        this.userType = userType;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @return
     */
    public String getUserType() {
        return userType;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     * @param userType
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }
}
