package com.example.user.thirsty;
import static org.junit.Assert.assertEquals;
import org.junit.Test;


/**
 * Created by Heather on 4/5/2017.
 */

public class getUserTest {
    @Test
    public void testUserTest() {
        UserDataBase tester = new UserDataBase();
        tester.createUser1("erika2", "pass", "erw@", "user");
        assertEquals("erika2 is a user, must return true", true, tester.getUser("erika2"));
        assertEquals("jimmyJohn is not a user, must return false", false, tester.getUser("jimmyJohn"));
    }
}

