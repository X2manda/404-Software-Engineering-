package com.berstek.uhacpayso.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.berstek.uhacpayso.staticData.AppVersion;
import com.berstek.uhacpayso.staticData.DatabaseSettings;
import com.berstek.uhacpayso.staticData.Transactions;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class HistoryDaysData extends SQLiteOpenHelper{

    private ArrayList<String> days = new ArrayList<>();
    private ArrayList<String> spendings = new ArrayList<>();

    public HistoryDaysData(Context context, String date) {
        super(context, DatabaseSettings.getDatabaseName(), null, AppVersion.getVersion());
        SQLiteDatabase db = this.getWritableDatabase();
        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        TotalSpendingGetter spendingGetter = new TotalSpendingGetter(context);
        Cursor c = db.rawQuery("select distinct transaction_date from cycle_" + date.replace("-", "_"), null);
        if(c.moveToFirst()){
            do{
                days.add(c.getString(0));
                spendings.add(decimalFormat.format(spendingGetter.getTotalSpending(c.getString(0))));
            }while(c.moveToNext());
        }
        c.close();

        Log.d(null, Integer.toString(days.size()));
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public List<HistoryDayItem> getData() {
        List<HistoryDayItem> data = new ArrayList<>();
        int i = days.size() - 1;
        for(;i >= 0; i--) {
            HistoryDayItem item = new HistoryDayItem();
            item.setDate(days.get(i));
            item.setSpending(spendings.get(i));
            data.add(item);
        }
        return data;
    }
}
