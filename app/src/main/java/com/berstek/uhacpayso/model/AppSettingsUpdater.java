package com.berstek.uhacpayso.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.berstek.uhacpayso.staticData.AppVersion;


/**
 * Created by John on 11/26/2016.
 */

public class AppSettingsUpdater extends SQLiteOpenHelper {

    private static final String COL_CURRENCY = "CURRENCY";
    private static final String COL_COUNTRY = "COUNTRY";
    private static final String COL_SYMBOL = "SYMBOL";
    private static final String COL_ISO = "ISO";
    private static final String COL_CYCLE_TYPE = "CYCLE_TYPE";
    private static final String COL_CYCLE_START = "CYCLE_START";
    private static final String COL_BUDGET = "BUDGET";
    private static final String COL_SETUP_STATUS = "SETUP_STATUS";

    private static final String DATABASE_NAME = "PAYSO_DATABASE";

    private static final String TABLE_APPSETTINGS = "APP_SETTINGS";

    private SQLiteDatabase db;

    public AppSettingsUpdater(Context context) {
        super(context, DATABASE_NAME, null, AppVersion.getVersion());
        db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void setCurrency(String currency) {
        update(COL_CURRENCY, currency);
    }

    public void setCountry(String country) {
        update(COL_COUNTRY, country);
    }

    public void setSymbol(String symbol) {
        update(COL_SYMBOL, symbol);
    }

    public void setIso(String iso) {
        update(COL_ISO, iso);
    }

    public void setCycleType(String cycleType) {
        update(COL_CYCLE_TYPE, cycleType);
    }

    public void setCycleStart(String cycleStart) {
        update(COL_CYCLE_START, cycleStart);
    }

    public void setBudget(double budget) {
        update(COL_BUDGET, budget);
    }

    public void setSetupStatus(int setupStatus) {
        update(COL_SETUP_STATUS, setupStatus);
    }

    private void update(String column, String value) {
        db.execSQL("update " + TABLE_APPSETTINGS + " set " + column + " = '" + value + "'");
    }

    private void update(String column, double value) {
        db.execSQL("update " + TABLE_APPSETTINGS + " set " + column + " = '" + value + "'");
    }

    private void update(String column, int value) {
        db.execSQL("update " + TABLE_APPSETTINGS + " set " + column + " = '" + value + "'");
    }

    public void disconnect() {
        db.close();
    }
}
