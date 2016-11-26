package com.berstek.uhacpayso.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.berstek.uhacpayso.R;
import com.berstek.uhacpayso.staticData.Currency;

import java.util.List;

/**
 * Created by John on 11/26/2016.
 */

public class CurrenciesAdapter extends RecyclerView.Adapter<CurrenciesAdapter.ListHolder> {

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

    public CurrenciesAdapter(List<Currency> listData, Context context) {
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
        Currency listItem = (Currency) listData.get(position);
        holder.country.setText(listItem.getCountry());
        holder.iso_currency.setText(listItem.getIso() + " - " + listItem.getCurrency());
        holder.symbol.setText(listItem.getSymbol());
    }

    @Override
    public int getItemCount() {
        return listData.size() ;
    }


    class ListHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView country, iso_currency, symbol;
        private View container;

        public ListHolder(View itemView) {
            super(itemView);
            container = itemView.findViewById(R.id.item_currency);
            country = (TextView) itemView.findViewById(R.id.txt_country);
            iso_currency = (TextView) itemView.findViewById(R.id.txt_iso_currency);
            symbol = (TextView) itemView.findViewById(R.id.txt_symbol);
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
