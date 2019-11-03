package com.example.trandangloc_16026311_btsqlite;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
    /*    CREATE TABLE SINHVIEN*/
    public static String TB_SINHVIEN = "SINHVIEN";

    public static String TB_SINHVIEN_IDSINHVIEN = "IDSINHVIEN";
    public static String TB_SINHVIEN_NAME = "NAME";
    public static String TB_SINHVIEN_CALSSNAME = "CLASSNAME";
    public static String TB_SINHVIEN_SUBJECT = "SUBJECT";

    /*    CREATE TABLE LOP*/
    public static String TB_LOP = "LOP";
    public static String TB_LOP_IDLOP = "IDLOP";
    public static String TB_LOP_NAME = "NAME";


    public Database(Context context) {
        super(context, "SVDB.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tbLop = "CREATE TABLE " + TB_LOP + " ( " + TB_LOP_IDLOP + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TB_LOP_NAME + " TEXT ) ";


        String tbSinhVien = "CREATE TABLE " + TB_SINHVIEN + " ( " + TB_SINHVIEN_IDSINHVIEN + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TB_SINHVIEN_NAME + " TEXT, " + TB_SINHVIEN_SUBJECT + " TEXT, "
                + TB_SINHVIEN_CALSSNAME + " TEXT ," + " FOREIGN KEY (" + TB_SINHVIEN_CALSSNAME + ") REFERENCES " + TB_LOP + "(" + TB_LOP_NAME + "));";


        db.execSQL(tbLop);
        db.execSQL(tbSinhVien);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public SQLiteDatabase open() {
        return this.getWritableDatabase();
    }
}
