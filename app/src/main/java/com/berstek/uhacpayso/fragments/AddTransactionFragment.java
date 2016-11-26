package com.berstek.uhacpayso.fragments;


import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.berstek.uhacpayso.R;
import com.berstek.uhacpayso.adapters.TransactionSelectionAdapter;
import com.berstek.uhacpayso.model.AddTransactionTempData;
import com.berstek.uhacpayso.model.TransactionSelectionData;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddTransactionFragment extends Fragment implements TransactionSelectionAdapter.ItemClickCallback{

    private TransactionSelectionData transactionSelectionData;

    public AddTransactionFragment() {
        // Required empty public constructor
    }

    private RecyclerView recyclerView;
    private TransactionSelectionAdapter adapter;
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_add_transaction, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recview_transactions_selection);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 5);

        transactionSelectionData = new TransactionSelectionData(view.getContext());
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new TransactionSelectionAdapter(transactionSelectionData.getData(), getActivity());
        recyclerView.setAdapter(adapter);
        adapter.setItemClickCallback(this);
        getActivity().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        return view;
    }

    @Override
    public void onItemClick(int p) {
        AddTransactionTempData tempData = new AddTransactionTempData(view.getContext());
        tempData.setType(transactionSelectionData.getData().get(p).getDetails());

        FragmentManager fragmentManager = getFragmentManager();
        EnterTransactionDetailsFragment fragment = new EnterTransactionDetailsFragment();
        fragment.setTempData(tempData);
        fragmentManager.beginTransaction().replace(R.id.fragment_lower_screen, fragment).addToBackStack(null).commit();

    }
}
