package knaph.uw.tacoma.edu.testinglab;

import org.junit.Test;
import static org.junit.Assert.*;


import knaph.uw.tacoma.edu.testinglab.authenticate.Account;

/**
 * Created by Kyle on 3/1/17.
 */

public class AccountTest {

    @Test
    public void testAccountConstructor() {
        assertNotNull(new Account("knaph@uw.edu", "test1@3"));
    }
    @Test
    public void testAccountConstructorBadEmail() {
        try {
            new Account("knaphuw.edu", "test1@3");
            fail("Account created with invalid email");
        } catch(IllegalArgumentException e) {

        }
    }

}
