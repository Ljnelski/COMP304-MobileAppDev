package com.example.roomexampleapplication;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1)
public abstract class MyAppDataBase extends RoomDatabase {
    public abstract MyDataAccessObject myDataAccessObject();
}
