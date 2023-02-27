package com.example.studentinfo.DataBase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.studentinfo.Models.StudentInfo;

import java.util.ArrayList;
import java.util.List;

public class DBHalper extends SQLiteOpenHelper {
    public DBHalper(@Nullable Context context) {
        super(context, "DB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE INFO (ID INTEGER PRIMARY KEY AUTOINCREMENT, FULLNAME TEXT, COURSE TEXT, DOB TEXT, ADTIME TEXT, GENDER TEXT, LANGUAGES TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addInfo(StudentInfo studentInfo){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO INFO (FULLNAME, COURSE, DOB, ADTIME, GENDER, LANGUAGES) VALUES ('" + studentInfo.getFullName() + "', '" + studentInfo.getCourse() + "', '" + studentInfo.getDob() + "', '" + studentInfo.getAdTime() + "', '" + studentInfo.getGender() + "', '" + studentInfo.getLanguages() + "')");
    }

    public List<StudentInfo> getAllInfo(){
        List<StudentInfo> list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM INFO", null);

        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String fullName = cursor.getString(1);
            String course = cursor.getString(2);
            String dob = cursor.getString(3);
            String adTime = cursor.getString(4);
            String gender = cursor.getString(5);
            String languages = cursor.getString(6);

            list.add(new StudentInfo(id, fullName, course, dob, adTime, gender, languages));
        }

        return list;
    }
}
