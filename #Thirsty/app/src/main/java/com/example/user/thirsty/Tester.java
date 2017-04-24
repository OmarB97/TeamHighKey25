package com.example.user.thirsty;

/**
 * Created by USER on 4/24/2017.
 */

public class Tester {
    public static void main(String[] args) {
        SendEmail.send("theofficialthirstyapp@gmail.com","emailpassword2340",  "dedding4341@gmail.com",
                "Password Recovery Request", "Hello, you have requested a password change. " +
                        "Please enter the following code in order to change your password: " + "98989A");
    }
}
