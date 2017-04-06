package com.example.user.thirsty;
import android.util.Log;

import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
/**
 * Unit tests for proper MD5 hashing
 *
 * @author Dennis Eddington
 * @version 1.0
 */
public class MD5UnitTest {
    private String[] unHashedPasswords;
    private String[] hashedPasswords;
    private static final int TIMEOUT = 200;

    @Before
    public void setUp() {

        unHashedPasswords = new String[5];
        unHashedPasswords[0] = "Cat";
        unHashedPasswords[1] = "Dog";
        unHashedPasswords[2] = "1337 PrOGRamm3R";
        unHashedPasswords[3] = "D1DsheNOTcomeBACK";
        unHashedPasswords[4] = "base###ball";

        hashedPasswords = new String[5];
        hashedPasswords[0] = "fa3ebd6742c360b2d9652b7f78d9bd7d";
        hashedPasswords[1] = "c935d187f0b998ef720390f85014ed1e";
        hashedPasswords[2] = "c733c939e7a91bb0f35d0da1eaba629f";
        hashedPasswords[3] = "08221ae4530a5fa4f581c212b8b360e1";
        hashedPasswords[4] = "0495d5eb736ced53bf96768d5dcc28ff";
    }

    @Test(timeout = TIMEOUT)
    public void testHashingSuccess() {
        assertEquals(hashedPasswords[0], com.example.user.thirsty.UserDataBase.MD5(unHashedPasswords[0]));
        assertEquals(hashedPasswords[1], com.example.user.thirsty.UserDataBase.MD5(unHashedPasswords[1]));
        assertEquals(hashedPasswords[2], com.example.user.thirsty.UserDataBase.MD5(unHashedPasswords[2]));
        assertEquals(hashedPasswords[3], com.example.user.thirsty.UserDataBase.MD5(unHashedPasswords[3]));
        assertEquals(hashedPasswords[4], com.example.user.thirsty.UserDataBase.MD5(unHashedPasswords[4]));
    }

    @Test(timeout = TIMEOUT)
    public void testHashingFailure() {
        assertNotEquals(com.example.user.thirsty.UserDataBase.MD5(unHashedPasswords[0]), unHashedPasswords[0]);
        assertNotEquals(com.example.user.thirsty.UserDataBase.MD5(unHashedPasswords[1]), unHashedPasswords[1]);
        assertNotEquals(com.example.user.thirsty.UserDataBase.MD5(unHashedPasswords[2]), unHashedPasswords[2]);
        assertNotEquals(com.example.user.thirsty.UserDataBase.MD5(unHashedPasswords[3]), unHashedPasswords[3]);
        assertNotEquals(com.example.user.thirsty.UserDataBase.MD5(unHashedPasswords[4]), unHashedPasswords[4]);
    }

}
