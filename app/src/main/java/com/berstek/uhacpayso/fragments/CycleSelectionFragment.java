package com.berstek.uhacpayso.fragments;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import com.berstek.uhacpayso.R;
import com.berstek.uhacpayso.model.SetupTempData;

/**
 * A simple {@link Fragment} subclass.
 */
public class CycleSelectionFragment extends Fragment {


    public CycleSelectionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cycle_selection, container, false);
        TextView currentCurrencyText = (TextView)view.findViewById(R.id.txt_current_currency);
        currentCurrencyText.setText(setupTempData.getCurrency() + "(" + setupTempData.getSymbol() + ")");
        listenToChangeCurrency(view);
        listenToRadio(view);
        return view;
    }

    private void listenToChangeCurrency(View view) {
        CardView cardView = (CardView)view.findViewById(R.id.card_change_currency);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new CurrencySelectionFragment();
                FragmentManager fn = getFragmentManager();
                FragmentTransaction ft = fn.beginTransaction();
                ft.replace(R.id.fragment_setup_fragment, fragment);
                ft.commit();
            }
        });
    }

    private void listenToRadio(View view) {
        RadioButton monthRB = (RadioButton)view.findViewById(R.id.radio_month);
        monthRB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new SelectDateFragment();
                FragmentManager fn = getFragmentManager();
                fn.beginTransaction().replace(R.id.fragment_setup_month, fragment).addToBackStack(null).commit();
            }
        });

        RadioButton weekRB = (RadioButton)view.findViewById(R.id.radio_week);
        weekRB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectDayFragment fragment = new SelectDayFragment();
                fragment.setSetupTempData(setupTempData);
                //fragment.setCurrency(message);
                FragmentManager fn = getFragmentManager();
                fn.beginTransaction().replace(R.id.fragment_setup_month, fragment).commit();
            }
        });
    }

    private SetupTempData setupTempData;

    public void setSetupTempData(SetupTempData setupTempData) {
        this.setupTempData = setupTempData;
    }
}
