package com.berstek.uhacpayso.staticData;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.berstek.uhacpayso.utils.CycleUtils;

import java.util.Random;

/**
 * Created by John on 11/26/2016.
 */

public class SessionQuoteGenerator extends SQLiteOpenHelper {

    private SQLiteDatabase db;

    public SessionQuoteGenerator(Context context) {
        super(context, DatabaseSettings.getDatabaseName(), null, AppVersion.getVersion());
        db = this.getWritableDatabase();
        try{
            db.execSQL(generateRandomQuoteIndex);
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(null, "ERROR LATEST");
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private String generateRandomQuoteIndex = "insert into DAILY_QUOTES_RECORD values ('" +
            CycleUtils.getCurrentDate() + "','" + getRandomNumber() + "')"
            ;

    private int getRandomNumber() {
        return new Random().nextInt(Quotes.getQuotes().length);
    }

    public int getQuoteIndex(String date) {
        int index = 0;
        try {
            Cursor d = db.rawQuery("select QUOTE_INDEX from DAILY_QUOTES_RECORD " +
                    "where SESSION_DATE ='" + date + "'", null);
            if(d.moveToFirst()){
                do{
                    index += d.getInt(0);
                }while(d.moveToNext());
            }
            d.close();
        } catch (Exception e) {
        }
        return index;
    }
}
