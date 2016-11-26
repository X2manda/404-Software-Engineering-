package com.berstek.uhacpayso.fragments;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.berstek.uhacpayso.R;
import com.berstek.uhacpayso.adapters.CycleHistoryAdapter;
import com.berstek.uhacpayso.model.CycleHistoryData;
import com.berstek.uhacpayso.utils.CycleUtils;


/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment implements CycleHistoryAdapter.ItemClickCallback{


    public HistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);


        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recview_history);
        recyclerView.setLayoutManager(gridLayoutManager);
        CycleHistoryData data = new CycleHistoryData(view.getContext());


        CycleHistoryAdapter adapter = new CycleHistoryAdapter(data.getData(), getActivity());
        recyclerView.setAdapter(adapter);
        adapter.setItemClickCallback(this);

        return view;
    }

    @Override
    public void onItemClick(int p) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction().addToBackStack(null);
        CashManagementFragment fragment = new CashManagementFragment();
        fragment.setDate(CycleUtils.getCurrentDate());
        transaction.replace(R.id.fragment_main_fragment, fragment);
        transaction.commit();
    }
}
