package com.berstek.uhacpayso.fragments;


import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.berstek.uhacpayso.R;
import com.berstek.uhacpayso.model.SetupTempData;


/**
 * A simple {@link Fragment} subclass.
 */
public class SelectDayFragment extends Fragment {

    public SelectDayFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_select_day, container, false);
        listenToDaySelection(view);
        return view;
    }

    private void listenToDaySelection(View view) {
        TextView mon = (TextView)view.findViewById(R.id.txt_select_monday);
        TextView tue = (TextView)view.findViewById(R.id.txt_select_tuesday);
        TextView wed = (TextView)view.findViewById(R.id.txt_select_wednesday);
        TextView thu = (TextView)view.findViewById(R.id.txt_select_thursday);
        TextView fri = (TextView)view.findViewById(R.id.txt_select_friday);
        TextView sat = (TextView)view.findViewById(R.id.txt_select_saturday);
        TextView sun = (TextView)view.findViewById(R.id.txt_select_sunday);

        setListener(mon);
        setListener(tue);
        setListener(wed);
        setListener(thu);
        setListener(fri);
        setListener(sat);
        setListener(sun);
    }

    private void setListener(final TextView view) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EnterBudgetFragment fragment = new EnterBudgetFragment();
                setupTempData.setCycleStart(view.getText().toString());
                setupTempData.setDivisor(7);
                setupTempData.setCycleType("WEEKLY");
                fragment.setSetupTempData(setupTempData);
                FragmentManager fn = getFragmentManager();
                fn.beginTransaction().replace(R.id.fragment_setup_fragment, fragment).commit();
            }
        });
    }

    private SetupTempData setupTempData;

    public void setSetupTempData(SetupTempData setupTempData) {
        this.setupTempData = setupTempData;
    }
}

