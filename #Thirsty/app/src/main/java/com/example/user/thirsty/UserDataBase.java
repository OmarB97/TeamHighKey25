package com.example.user.thirsty;

import android.util.Log;

import java.util.HashMap;

/**
 * Created by Dennis Eddington on 2/21/2017.
 * @author Dennis Eddington
 * @author Heather Song
 */


public class UserDataBase {

    private static HashMap<String, UserProfile> userDataBase;
    //private static UserProfile profile;

    public static void verifyDB() {
        if (userDataBase == null) {
            userDataBase = new HashMap<String, UserProfile>();
        }
    }
    /**
     * Constructor for user data base backed by a hashmap.
     */
    public UserDataBase() {
        userDataBase = new HashMap<String, UserProfile>();
    }

    /**
     * When called, will create a user in the user database by confirming information such as
     * username, password, email, and user type.
     *
     * @param username the username for the User/Admin to be created
     * @param password the password for the User/Admin to be created
     * @param email the email for the User/Admin to be created
     * @param userType the user type for the User/Admin to be created
     */
    public static void createUser(String username, String password, String email, String userType) {

        UserProfile profile;


        if (userType.equals("User")) {
            profile = new User(email, password, userType);
        } else if (userType.equals("Worker")) {
            profile = new User(email, password, userType);
        } else if (userType.equals("Manager")) {
            profile = new User(email, password, userType);
        } else {
            profile = new Admin(email, password, userType);
        }


        userDataBase.put(username, profile);
        WelcomeScreen.userDB.setValue(WelcomeScreen.users.getUserDataBase());
    }

    /**
     * Will create a MD5 encryption of the password entered by the user.
     *
     * @param password a plain text password to be encrypted before storage
     * @return MD5 encryption string
     */
    public static String MD5(String password) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(password.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }
    /**
     * Will return a boolean value confirming whether or not a username already exists within the
     * database.
     *
     * @param username the username to search the database for
     * @return a boolean value indicating whether or not the username exists in the database
     */
    public static boolean getUser(String username) {
        if (userDataBase.containsKey(username)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks the password entered for a particular user agianst the password stored in their user
     * profile within the user database.
     *
     * @param username the username for the user logging in
     * @param password the password to be checked agaisnt the correct password stored in the data
     *                 base
     * @return a boolean value indicating whether of not the password entered with the associated
     * username was corrrect
     */
    public static boolean getPassword(String username, String password) {
        Log.d("val", userDataBase.get(username).getClass() + "*******************************");
        if (password.equals(userDataBase.get(username).getPassword()) ){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Creates a dynamic toString for the username entered to be displayed upon successful login.
     *
     * @param username the username that succefully logged into the system
     * @return a string containing the email address and user type of the user
     */
    public static String getInfo(String username) {
        return "Your email is currently set as "
                + ((UserProfile) userDataBase.get(username)).getEmail()
                + " and your user type is "
                + (userDataBase.get(username)).getUserType() + ".";

    }

    public static String getUserType(String username) {
        return (userDataBase.get(username)).getUserType();
    }

    /**
     * Will update the email of a user that already exists within the database.
     *
     * @param username the username of the user who is attempting to update their email
     * @param email the email that is to be updated within the object of that user
     */
    public static void setEmail(String username, String email) {
        ((UserProfile) userDataBase.get(username)).setEmail(email);
    }

    /**
     * Will update the password of a user that already exists within the database.
     *
     * @param username the username of the user who is attempting to update their password
     * @param password the password that is to be updated within the object of that user
     */
    public static void setPassword(String username, String password) {
        ((UserProfile) userDataBase.get(username)).setPassword(password);
    }

    public static HashMap<String, UserProfile> getUserDataBase() {
        return userDataBase;
    }

    public static void setUserDataBase(HashMap<String, UserProfile> database) {
        userDataBase = database;
    }

}
