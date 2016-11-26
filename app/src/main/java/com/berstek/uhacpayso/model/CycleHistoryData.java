package com.berstek.uhacpayso.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.berstek.uhacpayso.staticData.AppVersion;
import com.berstek.uhacpayso.staticData.DatabaseSettings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by John on 11/26/2016.
 */

public class CycleHistoryData extends SQLiteOpenHelper {

    private ArrayList<String> start = new ArrayList<>();
    private ArrayList<String> cycleType = new ArrayList<>();
    private ArrayList<Double> budget = new ArrayList<>();
    private ArrayList<Double> totalSpending = new ArrayList<>();
    private Context context;

    public CycleHistoryData(Context context) {
        super(context, DatabaseSettings.getDatabaseName(), null, AppVersion.getVersion());
        SQLiteDatabase db = this.getWritableDatabase();
        this.context = context;
        getCyclesList(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private void getCyclesList(SQLiteDatabase db) {
        TotalSpendingGetter spendingGetter = new TotalSpendingGetter(context);
        try {
            Cursor c = db.rawQuery("select start, cycle_type, budget from cycles", null);
            if(c.moveToFirst()){
                do{
                    String date = c.getString(0);
                    start.add(date);
                    cycleType.add(c.getString(1));
                    budget.add(c.getDouble(2));
                    totalSpending.add(spendingGetter.getTotalSpending(date));

                }while(c.moveToNext());
            }
            c.close();
        } catch (Exception e) {

        }
    }

    public List<CycleHistoryItem> getData() {
        List<CycleHistoryItem> data = new ArrayList<>();

        for (int i = 0; i < start.size(); i++) {
            CycleHistoryItem item = new CycleHistoryItem();
            item.setStart(start.get(i));
            item.setBudget(budget.get(i));
            item.setCycleType(cycleType.get(i));
            item.setSpending(totalSpending.get(i));
            data.add(item);
        }
        return data;
    }
}
