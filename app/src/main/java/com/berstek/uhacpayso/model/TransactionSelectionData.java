package com.berstek.uhacpayso.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.berstek.uhacpayso.staticData.AppVersion;
import com.berstek.uhacpayso.staticData.Transactions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by John on 11/26/2016.
 */

public class TransactionSelectionData extends SQLiteOpenHelper {

    private ArrayList<String> transactions = new ArrayList<>();
    private ArrayList<Integer> priority = new ArrayList<>();


    public TransactionSelectionData(Context context) {
        super(context, "PAYSO_DATABASE", null, AppVersion.getVersion());
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(getTransactionSQL, null);
        if(c.moveToFirst()){
            do{
                transactions.add(c.getString(0));
                priority.add(c.getInt(1));
            }while(c.moveToNext());
        }
        c.close();
        db.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private String getTransactionSQL = "select distinct *from TRANSACTION_ITEMS";

    public List<TransactionSelectionItem> getData() {
        List<TransactionSelectionItem> data = new ArrayList<>();

        for (int i = 0; i < transactions.size(); i++) {
            TransactionSelectionItem item = new TransactionSelectionItem();
            item.setImageUrl(Transactions.getImageUrl(transactions.get(i)));
            item.setDetails(transactions.get(i));
            item.setPriority(priority.get(i));
            data.add(item);
        }
        return data;
    }
}
