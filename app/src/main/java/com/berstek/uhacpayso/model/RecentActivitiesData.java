package com.berstek.uhacpayso.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.berstek.uhacpayso.staticData.AppVersion;
import com.berstek.uhacpayso.staticData.Transactions;
import com.berstek.uhacpayso.utils.CycleUtils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by John on 11/26/2016.
 */

public class RecentActivitiesData extends SQLiteOpenHelper {

    private ArrayList<String> types = new ArrayList<>();
    private ArrayList<Double> costs = new ArrayList<>();
    private ArrayList<String> details = new ArrayList<>();

    private SQLiteDatabase db;
    private Context context;

    private static final String DATABASE_NAME = "PAYSO_DATABASE";

    private String date;
    public RecentActivitiesData(Context context, String date) {
        super(context, DATABASE_NAME, null, AppVersion.getVersion());
        db = this.getWritableDatabase();
        this.context = context;
        this.date = date;
    }

    public ArrayList<Double> getCosts() {
        return costs;
    }

    public void loadData() {
        Cursor c = db.rawQuery("select type, cost, details from CYCLE_" +
                new CycleData(context, date).getActiveCycle().replace("-", "_") + " where transaction_date = '" + date + "'", null);
        if(c.moveToFirst()){
            do{
                types.add(c.getString(0));
                costs.add(c.getDouble(1));
                details.add(c.getString(2));
            }while(c.moveToNext());
        }
        c.close();
    }

    private DecimalFormat d = new DecimalFormat("0.00");
    public List<RecentActivitiesItem> getData() {
        List<RecentActivitiesItem> data = new ArrayList<>();
        int i = types.size() - 1;
        for(;i >= 0; i--) {
            RecentActivitiesItem item = new RecentActivitiesItem();
            item.setType(types.get(i));
            item.setCost(d.format(costs.get(i)));
            item.setDetails(details.get(i));
            item.setImageUrl(Transactions.getImageUrl(item.getType()));
            data.add(item);
        }
        return data;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
