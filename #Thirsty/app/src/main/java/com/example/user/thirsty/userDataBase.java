package com.example.user.thirsty;

import java.util.HashMap;

/**
 * Created by USER on 2/21/2017.
 */

public class userDataBase {

    private static HashMap<String, Object> userDataBase;
    //private static UserProfile profile;

    public userDataBase() {
        userDataBase = new HashMap<String, Object>();
    }

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
