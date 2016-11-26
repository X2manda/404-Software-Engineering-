package com.berstek.uhacpayso.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by John on 11/26/2016.
 */

public class AppSettings extends SQLiteOpenHelper {

    private String currency = "";
    private String country = "";
    private String symbol = "";
    private String iso = "";
    private String cycleType = "";
    private String cycleStart = "";
    private double budget = 0;
    private int setupStatus = 0;

    private static final String DATABASE_NAME = "PAYSO_DATABASE";

    private static final String TABLE_APPSETTINGS = "APP_SETTINGS";

    private static final String COL_CURRENCY = "CURRENCY";
    private static final String COL_COUNTRY = "COUNTRY";
    private static final String COL_SYMBOL = "SYMBOL";
    private static final String COL_ISO = "ISO";
    private static final String COL_CYCLE_TYPE = "CYCLE_TYPE";
    private static final String COL_CYCLE_START = "CYCLE_START";
    private static final String COL_BUDGET = "BUDGET";
    private static final String COL_SETUP_STATUS = "SETUP_STATUS";


    public AppSettings(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor c = db.rawQuery(query(), null);
        if(c.moveToFirst()){
            do{
                currency = c.getString(0);
                country = c.getString(1);
                symbol = c.getString(2);
                iso = c.getString(3);
                cycleType = c.getString(4);
                cycleStart = c.getString(5);
                budget = c.getDouble(6);
                setupStatus = c.getInt(7);
            }while(c.moveToNext());
        }
        c.close();
        db.close();
    }

    private String query() {
       String query = "SELECT " +
               COL_CURRENCY + ", " +
               COL_COUNTRY + ", " +
               COL_SYMBOL + ", " +
               COL_ISO + ", " +
               COL_CYCLE_TYPE + ", " +
               COL_CYCLE_START + ", " +
               COL_BUDGET + ", " +
               COL_SETUP_STATUS +
               " from " + TABLE_APPSETTINGS;

        return query;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public String getCurrency() {
        return currency;
    }

    public String getCountry() {
        return country;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getIso() {
        return iso;
    }

    public String getCycleType() {
        return cycleType;
    }

    public String getCycleStart() {
        return cycleStart;
    }

    public double getBudget() {
        return budget;
    }

    public int getSetupStatus() {
        return setupStatus;
    }
}
