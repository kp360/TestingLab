package knaph.uw.tacoma.edu.testinglab.authenticate;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import knaph.uw.tacoma.edu.testinglab.R;

public class SignInActivity extends AppCompatActivity implements RegisterFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, new RegisterFragment() )
                .commit();
    }


    @Override
    public void login(String userid, String userpwd) {
        Account newAccount = new Account(userid, userpwd);

    }
}
