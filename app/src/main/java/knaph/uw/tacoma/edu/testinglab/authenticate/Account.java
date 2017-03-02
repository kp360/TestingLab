package knaph.uw.tacoma.edu.testinglab.authenticate;

import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.regex.Pattern;

/**
 * Created by Kyle on 2/28/17.
 */

public class Account {

    private String account_username;
    private String account_password;
    private final static int PASSWORD_LEN = 6;


    public Account(String account_username, String account_password) {
        this.account_username = account_username;
        this.account_password = account_password;
    }

    /**
     * Email validation pattern.
     */
    public static final Pattern EMAIL_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    );

    /**
     * Validates if the given input is a valid email address.
     *
     * @param email        The email to validate.
     * @return {@code true} if the input is a valid email. {@code false} otherwise.
     */
    public static boolean isValidEmail(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }

    /**
     * Validates if the given password is valid.
     * Valid password must be at last 6 characters long
     * with at least one digit and one symbol.
     *
     * @param password        The password to validate.
     * @return {@code true} if the input is a valid password.
     * {@code false} otherwise.
     */
    public static boolean isValidPassword(String password) {
        boolean foundDigit = false, foundSymbol = false;
        if  (password == null ||
                password.length() < PASSWORD_LEN)
            return false;
        for (int i=0; i<password.length(); i++) {
            if (Character.isDigit(password.charAt(i)))
                foundDigit = true;
            if (!Character.isLetterOrDigit(password.charAt(i)))
                foundSymbol = true;
        }
        return foundDigit && foundSymbol;
    }


    public String getAccount_username() {
        return account_username;
    }

    public void setAccount_username(String account_username) {

        try {
            if (isValidEmail(account_username)) {
                this.account_username = account_username;
            } else {throw new IllegalArgumentException();

            }
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    public String getAccount_password() {
        return account_password;
    }

    public void setAccount_password(String account_password) {
        try {
            if (isValidPassword(account_password)) {
                this.account_password = account_password;
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
