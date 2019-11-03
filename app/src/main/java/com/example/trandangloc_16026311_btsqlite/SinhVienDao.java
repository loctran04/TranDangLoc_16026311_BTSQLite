package com.example.trandangloc_16026311_btsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class SinhVienDao {
    SQLiteDatabase sqLiteDatabase;

    public SinhVienDao(Context context) {
        Database database = new Database(context);
        sqLiteDatabase = database.open();
    }


    public boolean AddSinhVien(SinhVien sinhVien) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Database.TB_SINHVIEN_NAME, sinhVien.getName());
        contentValues.put(Database.TB_SINHVIEN_CALSSNAME, sinhVien.getClassName());
        contentValues.put(Database.TB_SINHVIEN_SUBJECT, sinhVien.getSubject());
        long kiemtra = sqLiteDatabase.insert(Database.TB_SINHVIEN, null, contentValues);
        if (kiemtra != 0) {
            return true;
        } else {
            return false;
        }
    }

    public List<SinhVien> GetAllSinhVien() {
        List<SinhVien> sinhViens = new ArrayList<SinhVien>();
        String truyvan = "SELECT * FROM " + Database.TB_SINHVIEN;
        Cursor cursor = sqLiteDatabase.rawQuery(truyvan, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            SinhVien sinhVien = new SinhVien();
            sinhVien.setIdSinhVien(cursor.getInt(cursor.getColumnIndex(Database.TB_SINHVIEN_IDSINHVIEN)));
            sinhVien.setName(cursor.getString(cursor.getColumnIndex(Database.TB_SINHVIEN_NAME)));
            sinhVien.setSubject(cursor.getString(cursor.getColumnIndex(Database.TB_SINHVIEN_SUBJECT)));
            sinhVien.setClassName(cursor.getString(cursor.getColumnIndex(Database.TB_SINHVIEN_CALSSNAME)));
            sinhViens.add(sinhVien);
            cursor.moveToNext();
        }
        return sinhViens;
    }

    public boolean DeleteSinhVien(int idSinhVien) {
        long kiemtra = sqLiteDatabase.delete(Database.TB_SINHVIEN, " '" + idSinhVien + "' = " + Database.TB_SINHVIEN_IDSINHVIEN, null);
        if (kiemtra != 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean UpdateSinhVien(SinhVien sinhVien) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Database.TB_SINHVIEN_NAME, sinhVien.getName());
        contentValues.put(Database.TB_SINHVIEN_CALSSNAME, sinhVien.getClassName());
        contentValues.put(Database.TB_SINHVIEN_SUBJECT, sinhVien.getSubject());
        long kiemtra = sqLiteDatabase.update(Database.TB_SINHVIEN, contentValues, Database.TB_SINHVIEN_IDSINHVIEN + " =' " + sinhVien.getIdSinhVien() + "'", null);
        if (kiemtra != 0) {
            return true;
        } else {
            return false;
        }
    }
}
