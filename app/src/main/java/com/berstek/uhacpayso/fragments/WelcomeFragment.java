package com.berstek.uhacpayso.fragments;


import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.berstek.uhacpayso.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WelcomeFragment extends Fragment {

    private String message;


    public WelcomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);
        //listenToRadio(view);

        Fragment fragment = new CurrencySelectionFragment();
        FragmentManager fn = getFragmentManager();
        fn.beginTransaction().replace(R.id.fragment_setup_fragment, fragment).commit();
        return view;
    }
}
