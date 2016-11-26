package com.berstek.uhacpayso.fragments;


import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.berstek.uhacpayso.R;
import com.berstek.uhacpayso.activities.MainActivity;
import com.berstek.uhacpayso.model.AppSettingsUpdater;
import com.berstek.uhacpayso.model.CycleBuilder;
import com.berstek.uhacpayso.model.SetupTempData;

import java.text.DecimalFormat;

/**
 * A simple {@link Fragment} subclass.
 */
public class SetupConfirmationFragment extends Fragment {


    public SetupConfirmationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_setup_confirmation, container, false);
        populateFields(view);
        listenToConfirmB(view);
        listenToResetB(view);
        return view;
    }

    private SetupTempData setupTempData;

    public void setSetupTempData(SetupTempData setupTempData) {
        this.setupTempData = setupTempData;
    }

    private void populateFields(View view) {
        TextView symbol = (TextView)view.findViewById(R.id.txt_current_symbol);
        TextView cycle = (TextView)view.findViewById(R.id.txt_current_cycle);
        TextView dailyBudget = (TextView)view.findViewById(R.id.txt_daily_budget);

        symbol.setText(setupTempData.getCurrency() + " - " + setupTempData.getSymbol());
        cycle.setText("Starts every " + setupTempData.getCycleStart());
        dailyBudget.setText("Daily: "  + computeBudget());
    }

    private DecimalFormat decimalFormat = new DecimalFormat("0.00");
    private String computeBudget() {
        return setupTempData.getSymbol() + " " +
                decimalFormat.format(setupTempData.getBudget() / setupTempData.getDivisor());
    }

    private void listenToConfirmB(final View view) {
        Button button = (Button)view.findViewById(R.id.btn_confirm);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //new UpdateSetupStatus(view.getContext());

                AppSettingsUpdater updater = new AppSettingsUpdater(view.getContext());
                updater.setSetupStatus(1);
                updater.setBudget(setupTempData.getBudget());
                updater.setCycleType(setupTempData.getCycleType());
                updater.setCountry(setupTempData.getCountry());
                updater.setCurrency(setupTempData.getCurrency());
                updater.setCycleStart(setupTempData.getCycleStart());
                updater.setIso(setupTempData.getIso());
                updater.setSymbol(setupTempData.getSymbol());

                CycleBuilder cycleBuilder = new CycleBuilder(view.getContext());

                Intent intent = new Intent(view.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void listenToResetB(final View view) {
        Button button = (Button)view.findViewById(R.id.btn_reset);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CurrencySelectionFragment fragment = new CurrencySelectionFragment();
                FragmentManager fn = getFragmentManager();
                fn.beginTransaction().replace(R.id.fragment_setup_fragment, fragment).commit();
            }
        });
    }


}
