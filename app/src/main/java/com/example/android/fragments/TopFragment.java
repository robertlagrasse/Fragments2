package com.example.android.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by robert on 9/4/16.
 */

// implement View.OnClickListener so the fragment can pickup click events
public class TopFragment extends Fragment implements View.OnClickListener {
    Button button;
    int counter = 0;

    // Create a reference variable comm of type Communicator. Communicator is the
    // Interface we created and implemented in MainActivity

    Communicator comm;

    // Fragments are destroyed when orientation is changed. This will also destroy
    // the instance variables of the fragment, so when the new fragment comes
    // up after changing orientation, everything will be initialized. To prevent this
    // we add the onSaveInstanceState override method, and we throw whichever
    // variables we want to keep track of into the Bundle outstate. The bundle
    // stores thinngs in pairs. An arbitrary name as string, and the variable.

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter", counter);
    }


    // We also add the onCreate override method so when we fire up the fragment,
    // we take a look at the savedInstanceState Bundle, and see if we should be
    // holding over variables from the last time the fragment was executed.

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState == null)
        {
            counter = 0;
        }
        else
        {
            counter = savedInstanceState.getInt("counter", 0);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.top_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Assign the comm reference variable to the activity.
        // This means comm now points to MainActivity
        comm = (Communicator) getActivity();
        button = (Button) getActivity().findViewById(R.id.tf_button);
        button.setOnClickListener(this);
    }

    @Override
    // Override method required when we implement View.OnClickListener
    public void onClick(View view) {
        // increment a counter when the button gets clicked.
        counter ++;

        // This calls the respond method in MainActivity, since
        // comm points to mainActivity. This is how we can pass
        // data back from a fragment.
        comm.respond("The button was clicked " + counter + " times.");
    }

}

