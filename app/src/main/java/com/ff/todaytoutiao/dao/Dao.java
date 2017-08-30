package com.ff.todaytoutiao.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.andy.library.ChannelBean;
import com.ff.todaytoutiao.SQlite_Tablayout;

import java.util.ArrayList;

/**
 * 时间: 2017/8/16
 * 类作用:
 */

public class Dao {
    private final SQLiteDatabase db;
    private static final String TABLE = "tablayout";

    public Dao(Context context) {
        SQlite_Tablayout sQlite_tablayout = new SQlite_Tablayout(context);
        db = sQlite_tablayout.getWritableDatabase();
    }

    public void add(String name, int isSelect) {
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("isSelect", isSelect);
        db.insert(TABLE, null, values);
    }

    public void update(String name, int isSelect, int id) {
        db.execSQL("update tablayout set isSelect=?,name=? where id=?", new Object[]{isSelect,
                name, id});
    }

    public ArrayList<ChannelBean> select() {
//        isSelect=0代表true  1代表false
        Cursor cursor = db.query(TABLE, null, null, null, null, null, null);
        ArrayList<ChannelBean> list = new ArrayList<>();
        while (cursor.moveToNext()) {
            boolean isSelect = cursor.getInt(cursor.getColumnIndex("isSelect")) == 0 ? true : false;
            String name = cursor.getString(cursor.getColumnIndex("name"));
            list.add(new ChannelBean(name, isSelect));
        }
        return list;
    }
}
