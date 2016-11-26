package com.berstek.uhacpayso.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.berstek.uhacpayso.staticData.AppVersion;
import com.berstek.uhacpayso.utils.CycleUtils;


/**
 * Created by John on 11/26/2016.
 */

public class CycleBuilder extends SQLiteOpenHelper {

    private Context context;

    private static final String DATABASE_NAME = "PAYSO_DATABASE";
    private static final String TABLE_CYCLES = "CYCLES";

    private AppSettings appSettings;

    public CycleBuilder(Context context) {
        super(context, DATABASE_NAME, null, AppVersion.getVersion());
        this.context = context;
        SQLiteDatabase db = this.getWritableDatabase();

        appSettings = new AppSettings(context);

        String cycleType = appSettings.getCycleType();
        String cycleStart = appSettings.getCycleStart();

        Log.d(null, cycleStart + " XXXXXX " + CycleUtils.getCurrentDay());

        if (cycleType.equalsIgnoreCase("WEEKLY")) {
            if (CycleUtils.getCurrentDay().equalsIgnoreCase(cycleStart)) {
                clearStatus(db);
                insertCycle(db);
                createWeeklyCycleTable(db);
            }
        }
        else if(cycleType.equalsIgnoreCase("MONTHLY")) {

        }
        db.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private void insertCycle(SQLiteDatabase db) {
       try {
           db.execSQL("insert into " + TABLE_CYCLES + " values ('" +

                   CycleUtils.getCurrentDate() + "','" +
                   "" + "','" +
                   "WEEKLY" + "','" +
                   CycleUtils.getCurrentDay() + "','" +
                   "7" + "','" +
                   "1" + "','" +
                   appSettings.getBudget() + "')"
           );
       } catch(Exception e) {

       }
    }

    private static final String COL_TYPE = "TYPE";
    private static final String COL_COST = "COST";
    private static final String COL_DETAILS = "DETAILS";
    private static final String COL_TRANSACTION_DATE = "TRANSACTION_DATE";

    private void createWeeklyCycleTable(SQLiteDatabase db) {
        db.execSQL("create table CYCLE_" + CycleUtils.getCurrentDate().replace("-", "_") + "(" +
                COL_TYPE + " text," +
                COL_COST + " text," +
                COL_DETAILS + " text," +
                COL_TRANSACTION_DATE + " date)"
        );
    }

    private void clearStatus(SQLiteDatabase db) {
        db.execSQL("update cycles set status = '0' where status = '1' AND start != '" + CycleUtils.getCurrentDate() + "'");
    }
}
