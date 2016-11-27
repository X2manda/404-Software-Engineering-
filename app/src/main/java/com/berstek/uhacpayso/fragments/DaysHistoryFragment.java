package com.berstek.uhacpayso.fragments;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.berstek.uhacpayso.R;
import com.berstek.uhacpayso.adapters.HistoryDayAdapter;
import com.berstek.uhacpayso.model.HistoryDaysData;
import com.berstek.uhacpayso.utils.CycleUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class DaysHistoryFragment extends Fragment implements HistoryDayAdapter.ItemClickCallback {

    private RecyclerView recyclerView;
    private HistoryDayAdapter adapter;

    public DaysHistoryFragment() {
        // Required empty public constructor
    }

    private  HistoryDaysData data;
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_days_history, container, false);

        data = new HistoryDaysData(view.getContext(), CycleUtils.getCurrentDate());

        recyclerView = (RecyclerView) view.findViewById(R.id.recview_days_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new HistoryDayAdapter(data.getData(), getActivity());
        adapter.setItemClickCallback(this);
        Log.d(null, Integer.toString(data.getData().size()) + " SIZE SIZE SIZE");
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onItemClick(int p) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction().addToBackStack(null);
        CashManagementFragment fragment = new CashManagementFragment();
        fragment.setDate(CycleUtils.getCurrentDate());
        fragment.setDate(data.getData().get(p).getDate());
        fragment.setDate(CycleUtils.getCurrentDate());
        transaction.replace(R.id.fragment_main_fragment, fragment);
        transaction.commit();
    }
}
