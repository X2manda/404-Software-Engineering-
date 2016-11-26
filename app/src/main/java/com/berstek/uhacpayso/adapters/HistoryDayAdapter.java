package com.berstek.uhacpayso.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.berstek.uhacpayso.R;
import com.berstek.uhacpayso.model.HistoryDayItem;

import java.util.List;


/**
 * Created by John on 11/26/2016.
 */

public class HistoryDayAdapter extends RecyclerView.Adapter<HistoryDayAdapter.ListHolder> {

    private List listData;
    private LayoutInflater inflater;
    private Context context;

    private ItemClickCallback itemClickCallback;

    public interface ItemClickCallback {
        void onItemClick(int p);
    }

    public void setItemClickCallback(ItemClickCallback itemClickCallback) {
        this.itemClickCallback = itemClickCallback;
    }

    public HistoryDayAdapter(List<HistoryDayItem> listData, Context context) {
        this.listData = listData;
        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item_currency, parent, false);
        return new ListHolder(view);
    }

    @Override
    public void onBindViewHolder(ListHolder holder, int position) {
        HistoryDayItem listItem = (HistoryDayItem) listData.get(position);
        //holder.spending.setText(listItem.getSpending());
        holder.date.setText(listItem.getDate());

    }

    @Override
    public int getItemCount() {
        return listData.size() ;
    }


    class ListHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView date, spending;
        private View container;

        public ListHolder(View itemView) {
            super(itemView);
            container = itemView.findViewById(R.id.item_currency);
            spending = (TextView) itemView.findViewById(R.id.txt_spending);
            date = (TextView) itemView.findViewById(R.id.txt_date);
            container.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.item_currency) {
                itemClickCallback.onItemClick(getAdapterPosition());
            }
        }
    }
}
