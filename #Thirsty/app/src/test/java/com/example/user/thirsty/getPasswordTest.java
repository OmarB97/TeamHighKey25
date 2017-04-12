package com.example.user.thirsty;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
/**
 * Created by etrejo on 4/5/2017.
 */

public class getPasswordTest {

    @Test
    public void testPasswordTest() {
        UserDataBase testBase = new UserDataBase();
        testBase.createUser1("Erika", "peach", "erika@gmail.com", "user");
        assertEquals("Password is a match, should return true", true, testBase.getPassword("Erika", "peach"));
        assertEquals("Password is not a match, should return false", false, testBase.getPassword("Erika", "mango"));
    }
}
