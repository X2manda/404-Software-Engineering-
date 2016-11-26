package com.berstek.uhacpayso.fragments;


import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.berstek.uhacpayso.R;
import com.berstek.uhacpayso.model.AddTransactionTempData;
import com.berstek.uhacpayso.model.TransactionChoiceInserter;
import com.berstek.uhacpayso.model.TransactionInserter;


/**
 * A simple {@link Fragment} subclass.
 */
public class EnterTransactionDetailsFragment extends Fragment {

    public void setTempData(AddTransactionTempData tempData) {
        this.tempData = tempData;
    }

    private AddTransactionTempData tempData;

    public EnterTransactionDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_enter_transaction_details, container, false);
        listenToEnterDetailsTF(view);
        getActivity().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        return view;
    }


    private void listenToEnterDetailsTF(final View view) {
        final Button confirmB = (Button)view.findViewById(R.id.btn_confirm);
        final EditText costTF = (EditText)view.findViewById(R.id.tf_enter_amount);
        final EditText typeTF = (EditText)view.findViewById(R.id.tf_type) ;
        final EditText detailsTF = (EditText)view.findViewById(R.id.tf_enter_details);

        if(tempData.getType().equalsIgnoreCase("others")) {

        }
        else {
            typeTF.setText(tempData.getType());
        }

        confirmB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(typeTF.getText().toString().length() == 0) {
                    typeTF.setText("Others");
                }

                CashManagementFragment fragment = new CashManagementFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.fragment_main_fragment, fragment).addToBackStack(null).commit();

                TransactionInserter inserter = new TransactionInserter(view.getContext());
                inserter.insertTransaction(tempData.getCycle(), typeTF.getText().toString(),
                        costTF.getText().toString(), detailsTF.getText().toString());

                InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

                TransactionChoiceInserter choiceInserter = new TransactionChoiceInserter(view.getContext());
                try {
                    choiceInserter.addTransactionSelectionItem(typeTF.getText().toString());
                } catch (Exception e) {

                }
            }
        });
    }
}
