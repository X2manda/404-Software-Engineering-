package com.berstek.uhacpayso.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.berstek.uhacpayso.R;
import com.berstek.uhacpayso.adapters.CurrenciesAdapter;
import com.berstek.uhacpayso.model.SetupTempData;
import com.berstek.uhacpayso.staticData.CurrenciesData;

/*
 * A simple {@link Fragment} subclass.
 */
public class CurrencySelectionFragment extends Fragment implements CurrenciesAdapter.ItemClickCallback{

    private RecyclerView recyclerView;
    private CurrenciesAdapter adapter;

    public CurrencySelectionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_currency_selection, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recview_currency_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new CurrenciesAdapter(CurrenciesData.getData(), getActivity());
        recyclerView.setAdapter(adapter);
        adapter.setItemClickCallback(this);

        return view;
    }

    @Override
    public void onItemClick(int p) {
        CycleSelectionFragment fragment = new CycleSelectionFragment();

        SetupTempData setupTempData = new SetupTempData();
        setupTempData.setCurrency(CurrenciesData.getData().get(p).getCurrency());
        setupTempData.setSymbol(CurrenciesData.getData().get(p).getSymbol());
        setupTempData.setCountry(CurrenciesData.getData().get(p).getCountry());
        setupTempData.setIso(CurrenciesData.getData().get(p).getIso());

        fragment.setSetupTempData(setupTempData);
        FragmentManager fn = getFragmentManager();
        FragmentTransaction ft = fn.beginTransaction();
        ft.replace(R.id.fragment_setup_fragment, fragment);
        ft.setCustomAnimations(R.animator.enter_from_left, R.animator.exit_to_right);
        ft.commit();
    }
}
