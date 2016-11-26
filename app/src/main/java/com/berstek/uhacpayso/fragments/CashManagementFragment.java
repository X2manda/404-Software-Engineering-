package com.berstek.uhacpayso.fragments;


import android.app.Fragment;
import android.app.FragmentManager;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.berstek.uhacpayso.R;
import com.berstek.uhacpayso.model.AppSettings;
import com.berstek.uhacpayso.model.CycleData;

import java.text.DecimalFormat;

/**
 * A simple {@link Fragment} subclass.
 */
public class CashManagementFragment extends Fragment {

    public CashManagementFragment() {
        // Required empty public constructor
    }

    private DecimalFormat d = new DecimalFormat("0.00");
    private FloatingActionButton fab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_cash_management, container, false);

        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        progressBar.getIndeterminateDrawable().setColorFilter(Color.WHITE, PorterDuff.Mode.MULTIPLY);

        TextView dailyRemaining = (TextView)view.findViewById(R.id.txt_daily_remaining);
        TextView spendingOverAllowance = (TextView)view.findViewById(R.id.txt_spending_over_allowance);

        AppSettings settings = new AppSettings(view.getContext());
        CycleData cycleData = new CycleData(view.getContext());

        double totalDailySpending = cycleData.getDailyTotalSpending(),
                dailyAllowance = cycleData.getDailyBudget(),
                remainingDailyAllowance = dailyAllowance - totalDailySpending;

        spendingOverAllowance.setText(d.format(totalDailySpending) + "\nof\n" + d.format(dailyAllowance));
        dailyRemaining.setText(settings.getSymbol() + " " + d.format(remainingDailyAllowance));

        double progress = (totalDailySpending / dailyAllowance) * 100;
        progressBar.setProgress((int)progress);

        if(progress >= 100) {
            progressBar.getProgressDrawable().setColorFilter(Color.parseColor("#ff4d4d"), PorterDuff.Mode.SRC_IN);
        }
        else if (progress < 100 && progress > 60) {
            progressBar.getProgressDrawable().setColorFilter(Color.parseColor("#ffb84d"), PorterDuff.Mode.SRC_IN);
        }

        Log.d(null, Double.toString(progress));
        fab = (FloatingActionButton)view.findViewById(R.id.fab);
        fab.setVisibility(View.VISIBLE);
        listenToFAB();

        return view;
    }

    private void listenToFAB(){

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddTransactionFragment fragment = new AddTransactionFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment_lower_screen, fragment, "TRANSACTION").addToBackStack(null).commit();
                fab.setVisibility(View.INVISIBLE);
            }
        });
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        fab.setVisibility(View.VISIBLE);
    }

    public FloatingActionButton getFab() {
        return fab;
    }
}
