package com.berstek.uhacpayso.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.berstek.uhacpayso.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SelectDateFragment extends Fragment {

    public SelectDateFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_select_date, container, false);
        listenToButtons(view);
        return view;
    }

    private void listenToButtons(View view) {
        TextView btn1 = (TextView)view.findViewById(R.id.btn1);
        setListener(btn1);
        TextView btn2 = (TextView)view.findViewById(R.id.btn2);
        setListener(btn2);
        TextView btn3 = (TextView)view.findViewById(R.id.btn3);
        setListener(btn3);
        TextView btn4 = (TextView)view.findViewById(R.id.btn4);
        setListener(btn4);
        TextView btn5 = (TextView)view.findViewById(R.id.btn5);
        setListener(btn5);
        TextView btn6 = (TextView)view.findViewById(R.id.btn6);
        setListener(btn6);
        TextView btn7 = (TextView)view.findViewById(R.id.btn7);
        setListener(btn7);
        TextView btn8 = (TextView)view.findViewById(R.id.btn8);
        setListener(btn8);
        TextView btn9 = (TextView)view.findViewById(R.id.btn9);
        setListener(btn9);
        TextView btn10 = (TextView)view.findViewById(R.id.btn10);
        setListener(btn10);
        TextView btn11 = (TextView)view.findViewById(R.id.btn11);
        setListener(btn11);
        TextView btn12 = (TextView)view.findViewById(R.id.btn12);
        setListener(btn12);
        TextView btn13 = (TextView)view.findViewById(R.id.btn13);
        setListener(btn13);
        TextView btn14 = (TextView)view.findViewById(R.id.btn14);
        setListener(btn14);
        TextView btn15 = (TextView)view.findViewById(R.id.btn15);
        setListener(btn15);
        TextView btn16 = (TextView)view.findViewById(R.id.btn16);
        setListener(btn16);
        TextView btn17 = (TextView)view.findViewById(R.id.btn17);
        setListener(btn17);
        TextView btn18 = (TextView)view.findViewById(R.id.btn18);
        setListener(btn18);
        TextView btn19 = (TextView)view.findViewById(R.id.btn19);
        setListener(btn19);
        TextView btn20 = (TextView)view.findViewById(R.id.btn20);
        setListener(btn20);
        TextView btn21 = (TextView)view.findViewById(R.id.btn21);
        setListener(btn21);
        TextView btn22 = (TextView)view.findViewById(R.id.btn22);
        setListener(btn22);
        TextView btn23 = (TextView)view.findViewById(R.id.btn23);
        setListener(btn23);
        TextView btn24 = (TextView)view.findViewById(R.id.btn24);
        setListener(btn24);
        TextView btn25 = (TextView)view.findViewById(R.id.btn25);
        setListener(btn25);
        TextView btn26 = (TextView)view.findViewById(R.id.btn26);
        setListener(btn26);
        TextView btn27 = (TextView)view.findViewById(R.id.btn27);
        setListener(btn27);
        TextView btn28 = (TextView)view.findViewById(R.id.btn28);
        setListener(btn28);
        TextView btn29 = (TextView)view.findViewById(R.id.btn29);
        setListener(btn29);
        TextView btn30 = (TextView)view.findViewById(R.id.btn30);
        setListener(btn30);
    }

    private void setListener(final TextView textView) {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = Integer.parseInt(textView.getText().toString());
            }
        });
    }

    private int num = 0;
}
