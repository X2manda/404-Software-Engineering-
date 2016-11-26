package com.berstek.uhacpayso.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.berstek.uhacpayso.R;
import com.berstek.uhacpayso.model.TransactionSelectionItem;

import java.util.List;


/**
 * Created by John on 11/26/2016.
 */

public class TransactionSelectionAdapter extends RecyclerView.Adapter<TransactionSelectionAdapter.ListHolder>{

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

    public TransactionSelectionAdapter(List<TransactionSelectionItem> listData, Context context) {
        this.listData = listData;
        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item_transaction_selection, parent, false);
        return new ListHolder(view);
    }

    @Override
    public void onBindViewHolder(ListHolder holder, int position) {
        TransactionSelectionItem listItem = (TransactionSelectionItem) listData.get(position);
        holder.details.setText(listItem.getDetails());
        holder.transactionIcon.setImageResource(context.getResources().getIdentifier(listItem.getImageUrl(), null, context.getPackageName()));
    }

    @Override
    public int getItemCount() {
        return listData.size() ;
    }


    class ListHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView details;
        private ImageView transactionIcon;
        private View container;

        public ListHolder(View itemView) {
            super(itemView);

            details = (TextView)itemView.findViewById(R.id.txt_details);
            transactionIcon = (ImageView)itemView.findViewById(R.id.img_transaction_icon);
            transactionIcon.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemClickCallback.onItemClick(getAdapterPosition());

        }
    }
}
