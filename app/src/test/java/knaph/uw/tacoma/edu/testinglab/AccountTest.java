package knaph.uw.tacoma.edu.testinglab;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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
    @Test
    public void testAccountIsValidEmail() {
        Account acc = new Account("knaph@uw.edu", "test1@3");
        assertTrue(acc.isValidEmail("knaph@uw.edu"));
    }
    @Test
    public void testAccountIsValidEmailBadEmail() {
        Account acc = new Account("knaphuw.edu", "test1@3");
        assertFalse(acc.isValidEmail("knaphuw.edu"));
    }
    @Test
    public void testAccountIsValidPassword() {
        Account acc = new Account("knaph@uw.edu", "test1@3");
        assertTrue(acc.isValidPassword("Password1!"));
    }
    @Test
    public void testAccountIsValidPasswordNoPassword() {
        Account acc = new Account("knaph@uw.edu", "");
        assertFalse(acc.isValidPassword(""));
    }
    @Test
    public void testAccountIsValidPasswordNoDigit() {
        Account acc = new Account("knaph@uw.edu", "");
        assertFalse(acc.isValidPassword("Password!"));
    }
    @Test
    public void testAccountIsValidPasswordNoSymbol() {
        Account acc = new Account("knaph@uw.edu", "");
        assertFalse(acc.isValidPassword("Password1"));
    }
    @Test
    public void testAccountIsValidPasswordBadLength() {
        Account acc = new Account("knaph@uw.edu", "");
        assertFalse(acc.isValidPassword("Pas1!"));
    }
    @Test
    public void testAccountGetAccount() {
        Account acc = new Account("knaph@uw.edu", "test1@3");
        assertEquals(acc.getAccount_username(), "knaph@uw.edu");
    }
    @Test
    public void testAccountGetPassword() {
        Account acc = new Account("knaph@uw.edu", "test1@3");
        assertEquals(acc.getAccount_password(), "test1@3");
    }
    @Test
    public void testAccountSetAccount() {
        Account acc = new Account("knaph@uw.edu", "test1@3");
        acc.setAccount_username("knaph@uw.edu");
        assertEquals(acc.getAccount_username(), "knaph@uw.edu");
    }
    @Test
    public void testAccountSetAccountBadEmail() {
        try {
            Account acc = new Account("knaphuw.edu", "test1@3");
            acc.setAccount_username("knaphuw.edu");
        } catch(IllegalArgumentException e) {
        }
    }
    @Test
    public void testAccountSetPassword() {
        Account acc = new Account("knaph@uw.edu", "test1@3");
        acc.setAccount_password("test1@3");
        assertEquals(acc.getAccount_password(), "test1@3");
    }
    @Test
    public void testAccountSetPasswordNoPassword() {
        try {
            Account acc = new Account("knaphuw.edu", "test1@3");
            acc.setAccount_password("");
        } catch(IllegalArgumentException e) {
        }
    }
    @Test
    public void testAccountSetPasswordNoDigit() {
        try {
            Account acc = new Account("knaphuw.edu", "test1@3");
            acc.setAccount_password("test@");
        } catch(IllegalArgumentException e) {
        }
    }
    @Test
    public void testAccountSetPasswordNoDSymbol() {
        try {
            Account acc = new Account("knaphuw.edu", "test1@3");
            acc.setAccount_password("test13");
        } catch(IllegalArgumentException e) {
        }
    }
    @Test
    public void testAccountSetPasswordBadLength() {
        try {
            Account acc = new Account("knaphuw.edu", "test1@3");
            acc.setAccount_password("te1@3");
        } catch(IllegalArgumentException e) {
        }
    }
}
