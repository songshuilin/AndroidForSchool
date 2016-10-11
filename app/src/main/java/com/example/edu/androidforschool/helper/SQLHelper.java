package com.example.edu.androidforschool.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/10/9.
 */

public class SQLHelper extends SQLiteOpenHelper {

    private String sqlKind="create table kindall (" +
            "kind   primary key )";

    private String sqlInfo="create table info (" +
            "phone  primary key ," +
            " name ," +
            " infoid ," +
            "FOREIGN KEY(infoid) REFERENCES kindall(kind))";
    public SQLHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlKind);
        db.execSQL(sqlInfo);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    @Override
    public void onOpen(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        super.onOpen(db);
        if (!db.isReadOnly()) {
            // Enable foreign key constraints 开启外键约束
            db.execSQL("PRAGMA foreign_keys=ON;");
        }
    }

}
