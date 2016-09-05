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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.top_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        button = (Button) getActivity().findViewById(R.id.tf_button);
    }

    @Override
    // Override method required when we implement View.OnClickListener
    public void onClick(View view) {
        // increment a counter when the button gets clicked.
        counter ++;
    }
}

