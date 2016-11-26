package com.berstek.uhacpayso.fragments;


import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.berstek.uhacpayso.R;
import com.berstek.uhacpayso.adapters.RecentActivitiesAdapter;
import com.berstek.uhacpayso.model.CycleData;
import com.berstek.uhacpayso.model.RecentActivitiesData;
import com.berstek.uhacpayso.utils.CycleUtils;

import java.text.DecimalFormat;

/**
 * A simple {@link Fragment} subclass.
 */
public class CashDetailsFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecentActivitiesAdapter adapter;

    private String date;

    public CashDetailsFragment() {
        // Required empty public constructor
    }

    public void setDate(String date) {
        this.date = date;
    }

    DecimalFormat d = new DecimalFormat("0.00");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cash_details, container, false);

        CycleData cycleData = new CycleData(view.getContext(), date);

        TextView totalBudgetTxt = (TextView)view.findViewById(R.id.txt_total_budget);
        totalBudgetTxt.setText(d.format(cycleData.getTotalBudget() - cycleData.getTotalSpendings()));

        TextView estimatedSavingsTxt = (TextView)view.findViewById(R.id.txt_estimated_savings);
        estimatedSavingsTxt.setText(d.format(cycleData.getEstimatedSavings()));

        TextView transactionsTxt = (TextView)view.findViewById(R.id.txt_transactions);
        transactionsTxt.setText("Transactions (" + cycleData.getDailyTransactions() + ")");

        TextView dailyTotalExpense = (TextView)view.findViewById(R.id.txt_total_daily_expenses);

        recyclerView = (RecyclerView)view.findViewById(R.id.recview_recent_activities);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        RecentActivitiesData data = new RecentActivitiesData(view.getContext());
        data.loadData();

        adapter = new RecentActivitiesAdapter(data.getData(), getActivity());
        recyclerView.setAdapter(adapter);

        dailyTotalExpense.setText(d.format(cycleData.getTotalSpendings()));

        if(cycleData.getDailyTransactions() == 0) {
            DailyQuoteFragment dailyQuoteFragment = new DailyQuoteFragment();
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment_quote_place, dailyQuoteFragment).commit();
        }

        return view;
    }
}
