package com.example.user.thirsty;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

 //user admin worker manager
public class getUserTypeTest {

    UserDataBase tester = new UserDataBase();

    @Before
    public void setUp() {
        tester.createUser1("omar1", "pass", "omar1", "User");
        tester.createUser1("omar2", "pass", "omar2", "Admin");
        tester.createUser1("omar3", "pass", "omar3", "Worker");
        tester.createUser1("omar4", "pass", "omar4", "Manager");

    }

    @Test
    public void checkUser() {
        assertEquals("omar1 is not a \"user\"!", "User", tester.getUserType("omar1"));

    }

    @Test
    public void checkAdmin() {
        assertEquals("omar2 is not an \"admin\"!", "Admin", tester.getUserType("omar2"));
    }

    @Test
    public void checkWorker() {
        assertEquals("omar3 is not a \"worker\"!", "Worker", tester.getUserType("omar3"));

    }

    @Test
    public void checkManager() {
        assertEquals("omar4 is not a \"manager\"!", "Manager", tester.getUserType("omar4"));
    }

    @Test
    public void checkInvalidUser() {
        try {
            tester.getUserType("omar12345");
            fail("Found a user that doesn't exist in the database!");
        } catch(IllegalArgumentException e) {
            Assert.assertTrue(true);
            e.printStackTrace();
        }
    }
}