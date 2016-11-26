package com.berstek.uhacpayso.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.berstek.uhacpayso.R;
import com.berstek.uhacpayso.model.CycleHistoryItem;

import java.text.DecimalFormat;
import java.util.List;


/**
 * Created by John on 11/26/2016.
 */

public class CycleHistoryAdapter extends RecyclerView.Adapter<CycleHistoryAdapter.ListHolder>{

    private List listData;
    private LayoutInflater inflater;
    private Context context;

    public CycleHistoryAdapter(List<CycleHistoryItem> listData, Context context) {
        this.listData = listData;
        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item_history, parent, false);
        return new ListHolder(view);
    }

    @Override
    public void onBindViewHolder(ListHolder holder, int position) {
        DecimalFormat d = new DecimalFormat("0.00");
        CycleHistoryItem listItem = (CycleHistoryItem) listData.get(position);
        holder.date.setText(listItem.getStart());
        holder.totalSpending.setText(d.format(listItem.getSpending()) + "\nof\n" + d.format(listItem.getBudget()));
    }

    @Override
    public int getItemCount() {
        return listData.size() ;
    }


    class ListHolder extends RecyclerView.ViewHolder {

        private TextView date, totalSpending;
        private View container;

        public ListHolder(View itemView) {
            super(itemView);

            date = (TextView)itemView.findViewById(R.id.txt_date);
            totalSpending = (TextView)itemView.findViewById(R.id.txt_total_spending);
        }
    }
}
