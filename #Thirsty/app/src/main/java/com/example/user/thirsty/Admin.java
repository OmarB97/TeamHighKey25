package com.example.user.thirsty;

/**
 * Created by Dennis Eddington on 2/21/2017.
 * @author Dennis Eddington
 * @author Heather Song
 */

public class Admin extends UserProfile {
    private String password;
    private String email;
    private String userType;
    private String salt;
    private boolean isBanned = false;
    private int counter = 0;
    private String encoded;

    /**
     *Constructor for an admin object. Takes in an email, a password, and a user type and assigns
     * them to the object
     *
     * @param email the email for the Admin object
     * @param password the password for the Admin object
     * @param userType the userType for the Admin object
     */
    public Admin(String email, String password, String userType, String salt, boolean accStatus, String picCode) {
        this.password = password;
        this.email = email;
        this.userType = userType;
        this.salt = salt;
        this.isBanned = accStatus;
        this.encoded = picCode;
    }

    /**
     *Returns the password
     *
     * @return the string containing the password of the Admin object
     */
    public String getPassword() {
        return password;
    }

    /**
     *Return the email
     *
     * @return the string containing the email of the Admin object
     */
    public String getEmail() {
        return email;
    }
    public int getCounter() {
        return counter;
    }

    public void increaseCounter() {
        counter = counter +1;
    }
    public void clearCounter() {
        counter = 0;
    }


    /**
     *Returns the user type
     *
     * @return the string containing the user type of the Admin object
     */
    public String getUserType() {
        return userType;
    }

    /**
     *Sets the password
     *
     * @param password the password to be assigned to an Admin object
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Sets the email
     *
     * @param email the email to be assigned to an Admin object
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets the user type
     *
     * @param userType the user user type to be assigned to an Admin object
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getSalt() {
        return salt;
    }

    public boolean getAccountStatus() {
        return isBanned;
    }

    public void setAccountStatus(boolean status) {
        isBanned = status;
    }

    public void setProfilePic(String code) {
        this.encoded = code;
    }

    public String getProfilePic() {
        return encoded;
    }
}
