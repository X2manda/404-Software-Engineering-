package com.berstek.uhacpayso.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.berstek.uhacpayso.R;
import com.berstek.uhacpayso.model.RecentActivitiesItem;

import java.util.List;


/**
 * Created by John on 11/26/2016.
 */

public class RecentActivitiesAdapter extends RecyclerView.Adapter<RecentActivitiesAdapter.ListHolder>{

    private List listData;
    private LayoutInflater inflater;
    private Context context;

    public RecentActivitiesAdapter(List<RecentActivitiesItem> listData, Context context) {
        this.listData = listData;
        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item_recent_activity, parent, false);
        return new ListHolder(view);
    }

    @Override
    public void onBindViewHolder(ListHolder holder, int position) {
        RecentActivitiesItem listItem = (RecentActivitiesItem) listData.get(position);
        holder.type.setText(listItem.getType());
        holder.cost.setText(listItem.getCost());
        holder.details.setText(listItem.getDetails());
        holder.transactionIcon.setImageResource(context.getResources().getIdentifier(listItem.getImageUrl(), null, context.getPackageName()));
    }

    @Override
    public int getItemCount() {
        return listData.size() ;
    }


    class ListHolder extends RecyclerView.ViewHolder {

        private TextView type, cost, details;
        private ImageView transactionIcon;
        private View container;

        public ListHolder(View itemView) {
            super(itemView);

            type = (TextView)itemView.findViewById(R.id.tf_type);
            details = (TextView)itemView.findViewById(R.id.txt_details);
            cost = (TextView)itemView.findViewById(R.id.txt_cost);
            transactionIcon = (ImageView)itemView.findViewById(R.id.img_transaction_icon);
        }
    }
}
