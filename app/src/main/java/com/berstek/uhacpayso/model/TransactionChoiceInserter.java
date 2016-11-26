package com.berstek.uhacpayso.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.berstek.uhacpayso.staticData.AppVersion;
import com.berstek.uhacpayso.staticData.DatabaseSettings;


/**
 * Created by John on 11/26/2016.
 */

public class TransactionChoiceInserter extends SQLiteOpenHelper {

    private SQLiteDatabase db;
    public TransactionChoiceInserter(Context context) {
        super(context, DatabaseSettings.getDatabaseName(), null, AppVersion.getVersion());
        db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addTransactionSelectionItem(String item) {
        db.execSQL("insert into transaction_items values ('" + item + "','" + "0')");
        db.close();
    }
}
