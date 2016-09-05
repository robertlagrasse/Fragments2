package com.example.android.fragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


// Implement the Communicator Interface. Requires implementation of all
// Communicator methods
public class MainActivity extends AppCompatActivity implements Communicator{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // This is the method the Communicator Interface requires
    @Override
    public void respond(String data) {

    }
}
