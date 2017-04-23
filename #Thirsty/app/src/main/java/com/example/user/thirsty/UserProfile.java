package com.example.user.thirsty;

/**
 * Created by Dennis Eddington on 2/21/2017.
 * @author Dennis Eddington
 * @author Heather Song
 */


public abstract class UserProfile {

    /**
     * Returns the password of the UserProfile
     *
     * @return the password of the object
     */
    abstract String getPassword();

    /**
     * Returns the email of the UserProfile
     *
     * @return the email of the object
     */
    abstract String getEmail();

    /**
     * Returns the user type of the UserProfile
     *
     * @return the user type of the object
     */
    abstract String getUserType();

    /**
     * Sets the password of the UserProfile
     *
     * @param password the password to be set to the object
     */
    abstract void setPassword(String password);

    /**
     * Sets the email of the UserProfile
     *
     * @param email the email to be set to the object
     */
    abstract void setEmail(String email);

    abstract String getSalt();

    abstract boolean getAccountStatus();

    abstract void setAccountStatus(boolean status);
    abstract int getCounter();
    abstract void increaseCounter();
    abstract void clearCounter();

}
