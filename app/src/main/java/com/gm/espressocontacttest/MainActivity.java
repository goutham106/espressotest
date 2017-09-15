package com.gm.espressocontacttest;

import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @VisibleForTesting
    protected static final int SELECT_POSITION = 10;

    @VisibleForTesting
    protected static final String MATCH_CONTACT_NAME_IN_TOAST = "Ir" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container_main, new ContactsFragment())
                .commit();
    }
}
