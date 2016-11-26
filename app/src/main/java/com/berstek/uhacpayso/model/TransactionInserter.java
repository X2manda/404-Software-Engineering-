package com.berstek.uhacpayso.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.berstek.uhacpayso.staticData.AppVersion;
import com.berstek.uhacpayso.utils.CycleUtils;

/**
 * Created by John on 11/26/2016.
 */

public class TransactionInserter extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "PAYSO_DATABASE";
    private SQLiteDatabase db;

    public TransactionInserter(Context context) {
        super(context, DATABASE_NAME, null, AppVersion.getVersion());
        db = this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertTransaction(String cycle, String type, String cost, String details) {
        db.execSQL("insert into CYCLE_" + cycle.replace("-", "_") + " values ('" +
                type + "','" +
                cost + "','" +
                details + "','" +
                CycleUtils.getCurrentDate() + "')"
        );
        db.close();
    }

}
