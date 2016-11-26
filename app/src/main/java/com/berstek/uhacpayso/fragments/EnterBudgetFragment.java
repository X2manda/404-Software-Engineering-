package com.berstek.uhacpayso.fragments;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.method.DigitsKeyListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.berstek.uhacpayso.R;
import com.berstek.uhacpayso.model.SetupTempData;

import java.text.DecimalFormat;

/**
 * A simple {@link Fragment} subclass.
 */
public class EnterBudgetFragment extends Fragment {

    public EnterBudgetFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_enter_budget, container, false);
        loadPassedData(view);
        listenToBudgetType(view);
        listenToChangeCurrency(view);
        listenToChangeCycle(view);
        getActivity().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        return view;
    }

    private void loadPassedData(View view) {
        TextView currentCurrency = (TextView) view.findViewById(R.id.txt_current_currency);
        currentCurrency.setText(setupTempData.getCurrency() + "(" + setupTempData.getSymbol() + ")");
        TextView currentCycle = (TextView) view.findViewById(R.id.txt_current_cycle);
        currentCycle.setText("CycleData starts every " + setupTempData.getCycleStart() + ".");
    }

    private void listenToBudgetType(final View view) {
        final TextView estimatedBudget = (TextView) view.findViewById(R.id.txt_estimated_budget);

        final EditText editText = (EditText) view.findViewById(R.id.tf_enter_budget);
        editText.setKeyListener(DigitsKeyListener.getInstance(true,true));
        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                estimatedBudget.setText(estimate(editText.getText().toString()));

                if(event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {

                    SetupConfirmationFragment fragment = new SetupConfirmationFragment();
                    setupTempData.setBudget(Double.parseDouble(editText.getText().toString()));
                    fragment.setSetupTempData(setupTempData);
                    FragmentManager fn = getFragmentManager();
                    fn.beginTransaction().replace(R.id.fragment_setup_fragment, fragment).commit();
                }

                return false;
            }
        });
    }

    private DecimalFormat decimalFormat = new DecimalFormat("0.00");

    private String estimate(String budget) {
        double b = 0;
        try {
            b = Double.parseDouble(budget);

        } catch (NumberFormatException e) {
            return "Only numbers are allowed.";
        }
        return "Daily Budget: " + setupTempData.getSymbol() + " " + decimalFormat.format(b / setupTempData.getDivisor());
    }

    private SetupTempData setupTempData;

    public void setSetupTempData(SetupTempData setupTempData) {
        this.setupTempData = setupTempData;
    }

    private void listenToChangeCurrency(View view) {
        CardView cardView = (CardView)view.findViewById(R.id.card_change_currency);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CurrencySelectionFragment fragment = new CurrencySelectionFragment();
                FragmentManager fn = getFragmentManager();
                FragmentTransaction ft = fn.beginTransaction();
                ft.replace(R.id.fragment_setup_fragment, fragment);
                ft.commit();
            }
        });
    }

    private void listenToChangeCycle(View view) {
        CardView cardView = (CardView)view.findViewById(R.id.card_change_cycle);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CycleSelectionFragment fragment = new CycleSelectionFragment();
                fragment.setSetupTempData(setupTempData);
                FragmentManager fn = getFragmentManager();
                FragmentTransaction ft = fn.beginTransaction();
                ft.replace(R.id.fragment_setup_fragment, fragment);
                ft.commit();
            }
        });
    }
}
