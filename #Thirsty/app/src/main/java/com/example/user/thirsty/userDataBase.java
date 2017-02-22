package com.example.user.thirsty;

import java.util.HashMap;

/**
 * Created by USER on 2/21/2017.
 */

public class userDataBase {

    private static HashMap<String, Object> userDataBase;
    //private static UserProfile profile;

    /**
     * Constructer for user data base backed by a hashmap
     */
    public userDataBase() {
        userDataBase = new HashMap<String, Object>();
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
    }

    /**
     * Will return a boolean value confirming whether or not a username already exists within the
     * database
     * 
     * @param username
     * @return
     */
    public static boolean getUser(String username) {
        if (userDataBase.containsKey(username)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean getPassword(String username, String password) {
        if (password.equals(((UserProfile) userDataBase.get(username)).getPassword())) {
            return true;
        } else {
            return false;
        }
    }

    public static String getInfo(String username) {
        return "Your email is currently set as "
                + ((UserProfile) userDataBase.get(username)).getEmail()
                + " and your user type is "
                + ((UserProfile) userDataBase.get(username)).getUserType() + ".";

    }

    public static void setEmail(String username, String email) {
        ((UserProfile) userDataBase.get(username)).setEmail(email);
    }

    public static void setPassword(String username, String password) {
        ((UserProfile) userDataBase.get(username)).setPassword(password);
    }

}
