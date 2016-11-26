package com.berstek.uhacpayso.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.berstek.uhacpayso.R;
import com.berstek.uhacpayso.activities.InitialSetupActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class WelcomeQuoteFragment extends Fragment {


    public WelcomeQuoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_welcome_quote, container, false);
        FloatingActionButton confirmB = (FloatingActionButton)view.findViewById(R.id.fab_next);

        confirmB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), InitialSetupActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

}
