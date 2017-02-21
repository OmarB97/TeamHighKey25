package com.example.user.thirsty;

import java.util.HashMap;

/**
 * Created by USER on 2/21/2017.
 */

public class userDataBase {

    private static HashMap<String, String> userDataBase;

    public userDataBase() {
        userDataBase = new HashMap<String, String>();
    }

    public static void createUser(String username, String password) {
        userDataBase.put(username, password);
    }

    public static boolean getUser(String username) {
        if (userDataBase.containsKey(username)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean getPassword(String username, String password) {
        if (password.equals(userDataBase.get(username))) {
            return true;
        } else {
            return false;
        }
    }

}
