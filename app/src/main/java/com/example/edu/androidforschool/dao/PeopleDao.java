package com.example.edu.androidforschool.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.edu.androidforschool.bean.PhoneInfo;
import com.example.edu.androidforschool.bean.PhoneKind;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/9.
 */

public class PeopleDao {

    public static void insert(PhoneKind kind, PhoneInfo info, SQLiteDatabase db) {
        List<PhoneKind> listkind=selectKindForKind(db,kind);
        List<PhoneInfo> listinfo=selectInfoForPhone(db,info);
        if (listkind.isEmpty()){
            db.execSQL("insert into kindall (kind) values(?)", new String[]{kind.getKind()});
        }
        if (listinfo.isEmpty()){
            db.execSQL("insert into info (name,phone,infoid) values(?,?,?)", new String[]{info.getName(), info.getPhone(), kind.getKind()});
    }
    }

    /**
     *查询所有
     * @param db
     * @return
     */
    public static List<PhoneKind> selectKind(SQLiteDatabase db) {
        List<PhoneKind> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from kindall", null);
        while (cursor.moveToNext()) {
            String kind = cursor.getString(cursor.getColumnIndex("kind"));
            PhoneKind bean = new PhoneKind();
            bean.setKind(kind);
            list.add(bean);
        }
        return list;
    }

    public static List<PhoneKind> selectKindForKind(SQLiteDatabase db,PhoneKind phoneKind) {
        List<PhoneKind> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from kindall where kind=?", new String[]{phoneKind.getKind()});
        while (cursor.moveToNext()) {
            String kind = cursor.getString(cursor.getColumnIndex("kind"));
            PhoneKind bean = new PhoneKind();
            bean.setKind(kind);
            list.add(bean);
        }
        return list;
    }

    public static List<PhoneInfo> selectInfo(SQLiteDatabase db, PhoneKind kind) {
        List<PhoneInfo> list = new ArrayList<>();
        Cursor cursor =db.rawQuery("select * from info where infoid=?",new String[]{kind.getKind()});
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String phone = cursor.getString(cursor.getColumnIndex("phone"));
            PhoneInfo info = new PhoneInfo();
            info.setName(name);
            info.setPhone(phone);
            list.add(info);
        }
        return list;
    }

    public static List<PhoneInfo> selectInfoForPhone(SQLiteDatabase db, PhoneInfo phoneinfo) {
        List<PhoneInfo> list = new ArrayList<>();
        Cursor cursor =db.rawQuery("select * from info where phone=?",new String[]{phoneinfo.getPhone()});
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String phone = cursor.getString(cursor.getColumnIndex("phone"));
            PhoneInfo info = new PhoneInfo();
            info.setName(name);
            info.setPhone(phone);
            list.add(info);
        }
        return list;
    }

    /**
     * 查询所有
     * @param db
     * @return
     */

    public static List<PhoneInfo> selectInfoAll(SQLiteDatabase db) {
        List<PhoneInfo> list = new ArrayList<>();
        Cursor cursor =db.rawQuery("select * from info ",null);
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String phone = cursor.getString(cursor.getColumnIndex("phone"));
            PhoneInfo info = new PhoneInfo();
            info.setName(name);
            info.setPhone(phone);
            list.add(info);
        }
        return list;
    }

    public static List<PhoneInfo>  selectInfoAllFromNameOrPhone(SQLiteDatabase db,String key){
        List<PhoneInfo> list = new ArrayList<>();
        Cursor cursor=db.rawQuery("select * from info where name like ? or phone like ?" ,new String[]{"%"+key+"%","%"+key+"%"});
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String phone = cursor.getString(cursor.getColumnIndex("phone"));
            PhoneInfo info = new PhoneInfo();
            info.setName(name);
            info.setPhone(phone);
            list.add(info);
        }

        return list;
    }
}
