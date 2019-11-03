package com.example.trandangloc_16026311_btsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class LopDao {
    SQLiteDatabase sqLiteDatabase;

    public LopDao(Context context) {
        Database database = new Database(context);
        sqLiteDatabase = database.open();
    }


    public boolean AddLop(Lop lop) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Database.TB_LOP_NAME, lop.getName());
        long kiemtra = sqLiteDatabase.insert(Database.TB_LOP, null, contentValues);
        if (kiemtra != 0) {
            return true;
        } else {
            return false;
        }
    }
}
