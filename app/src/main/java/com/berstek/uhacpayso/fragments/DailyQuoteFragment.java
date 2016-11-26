package com.berstek.uhacpayso.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.berstek.uhacpayso.R;
import com.berstek.uhacpayso.staticData.Quotes;
import com.berstek.uhacpayso.staticData.SessionQuoteGenerator;
import com.berstek.uhacpayso.utils.CycleUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class DailyQuoteFragment extends Fragment {


    public DailyQuoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_daily_quote, container, false);
        loadQuote(view);
        return view;
    }

    private void loadQuote(View view) {
        TextView quote = (TextView)view.findViewById(R.id.txt_quote);
        TextView author = (TextView)view.findViewById(R.id.txt_author);

        try {
            SessionQuoteGenerator generator = new SessionQuoteGenerator(view.getContext());

            String[] quotes = Quotes.getQuotes();
            String[] authors = Quotes.getAuthors();

            quote.setText("\"" + quotes[generator.getQuoteIndex(CycleUtils.getCurrentDate())] + "\"");
            author.setText("-" + authors[generator.getQuoteIndex(CycleUtils.getCurrentDate())]);
        } catch (Exception e) {

        }
    }
}
