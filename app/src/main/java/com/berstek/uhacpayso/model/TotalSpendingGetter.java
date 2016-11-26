package com.berstek.uhacpayso.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.berstek.uhacpayso.staticData.AppVersion;
import com.berstek.uhacpayso.staticData.DatabaseSettings;


/**
 * Created by John on 11/26/2016.
 */

public class TotalSpendingGetter extends SQLiteOpenHelper {

    private SQLiteDatabase db;
    public TotalSpendingGetter(Context context) {
        super(context, DatabaseSettings.getDatabaseName(), null, AppVersion.getVersion());
        db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public double getTotalSpending(String date) {
        double sum = 0;
        Cursor c = db.rawQuery("select sum(cost) from CYCLE_" + date.replace("-", "_"), null);
        if(c.moveToFirst()){
            do{
                sum = c.getDouble(0);

            }while(c.moveToNext());
        }
        c.close();
        db.close();
        return sum;
    }
}
