package com.example.week10inclass_sql_lite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class UserDatabase extends SQLiteOpenHelper {

    public UserDatabase(@Nullable Context context) {
        super(context, "user.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableStatement = "CREATE TABLE USERDB(ID_COLUMN INTEGER PRIMARY KEY AUTOINCREMENT, NAME_COLUMN TXT)";
        sqLiteDatabase.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addOne(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("NAME_COLUMN", user.getName());
        long insert = db.insert("USERDB", null, cv);
        if(insert == -1) return false;
        else return true;
    }

    public List<User> getAll(){
        List<User> returnList = new ArrayList<>();
        String queryStatement = "SELECT * FROM USERDB";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryStatement,null);
        if (cursor.moveToFirst()){
            do {
                int userID = cursor.getInt(0);
                String userName = cursor.getString(1);
                User user = new User(userID, userName);
                returnList.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return returnList;
    }
    public List<User> getByName(String name){
        List<User> returnList = new ArrayList<>();
        String queryStatement = "SELECT * FROM USERDB WHERE NAME_COLUMN='"+name+"'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryStatement,null);
        if (cursor.moveToFirst()){
            do {
                int userID = cursor.getInt(0);
                String userName = cursor.getString(1);
                User user = new User(userID, userName);
                returnList.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return returnList;
    }
}
