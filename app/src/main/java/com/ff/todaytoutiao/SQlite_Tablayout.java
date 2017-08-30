package com.ff.todaytoutiao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 时间: 2017/8/16
 * 类作用:
 */

public class SQlite_Tablayout extends SQLiteOpenHelper {
    public SQlite_Tablayout(Context context) {
        super(context, "tablayout.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table tablayout(id Integer primary key autoincrement,name varchar ," +
                "isSelect Integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
