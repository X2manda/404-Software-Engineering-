package com.berstek.uhacpayso.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.berstek.uhacpayso.utils.CycleUtils;
import com.berstek.uhacpayso.utils.WeeklyDifferential;

/**
 * Created by John on 11/26/2016.
 */

public class CycleData extends SQLiteOpenHelper {

    private double dailyTotalSpending = 0;
    private int dailyTransactions = 0;
    private double totalSpending = 0;
    private double totalPreviousSpending = 0;
    private boolean hasActiveCycle = true;
    private int totalDays = 0;
    private String activeCycle = "", startDay = "";
    private double totalBudget = 0;
    private static final String DATABASE_NAME = "PAYSO_DATABASE";
    private String activeCycleQuery = "select * from cycles where status = 1";

    private SQLiteDatabase db;
    private String date;

    public CycleData(Context context, String date) {
        super(context, DATABASE_NAME, null, 1);
        db = this.getWritableDatabase();
        this.date = date;
        loadActiveCycleData();
        loadCycleTotalSpending();
        loadDailyTotalSpending();
        loadPreviousSpending();

        db.close();
    }

    private void loadCycleTotalSpending() {
        try {
            Cursor d = db.rawQuery("select cost from CYCLE_" + activeCycle.replace("-", "_"), null);
            if(d.moveToFirst()){
                do{
                    totalSpending += d.getDouble(0);
                }while(d.moveToNext());
            }
            d.close();
        } catch (Exception e) {
            hasActiveCycle = false;
        }
    }

    private void loadActiveCycleData() {
        Cursor c = db.rawQuery(activeCycleQuery, null);
        if(c.moveToFirst()){
            do{
                activeCycle = c.getString(0);
                startDay = c.getString(3);
                totalDays = c.getInt(4);
                totalBudget = c.getDouble(6);
            }while(c.moveToNext());
        }
        c.close();
    }

    private void loadDailyTotalSpending() {
        try {
            Cursor c = db.rawQuery("select cost from CYCLE_" + activeCycle.replace("-", "_") +
                    " where transaction_date = '" +  CycleUtils.getCurrentDate() + "'", null);
            if(c.moveToFirst()){
                do{
                    dailyTotalSpending += c.getDouble(0);
                    dailyTransactions ++;
                }while(c.moveToNext());
            }
            c.close();
        } catch (Exception e) {

        }
    }

    private void loadPreviousSpending() {
        try {
            Cursor c = db.rawQuery("select cost from CYCLE_" + activeCycle.replace("-", "_") +
                    " where transaction_date != '" +  CycleUtils.getCurrentDate() + "'", null);
            if(c.moveToFirst()){
                do{
                    totalPreviousSpending += c.getDouble(0);
                }while(c.moveToNext());
            }
            c.close();
        } catch (Exception e) {

        }
    }

    public double getEstimatedSavings() {
        return (totalBudget - totalPreviousSpending) - (dailyTotalSpending * getRemainingDays());
    }

    public boolean hasActiveCycle() {
        return hasActiveCycle;
    }

    public double getTotalBudget() {
        return totalBudget;
    }

    public double getDailyBudget() {
        Log.d(null, "TOTAL BUDGET = " + totalBudget);
        Log.d(null, "TOTAL PreviousSpending = " + totalPreviousSpending);

        return (totalBudget - totalPreviousSpending) / WeeklyDifferential.getDayDifference(startDay, CycleUtils.getCurrentDay());
    }

    public double getDailyTotalSpending() {
        return dailyTotalSpending;
    }

    public int getRemainingDays() {

        return WeeklyDifferential.getDayDifference(startDay, CycleUtils.getCurrentDay());
    }

    public int getTotalDays() {
        return totalDays;
    }

    public double getTotalSpendings() {
        return totalSpending;
    }

    public String getActiveCycle() {
        return activeCycle;
    }


    public int getDailyTransactions() {
        return dailyTransactions;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
