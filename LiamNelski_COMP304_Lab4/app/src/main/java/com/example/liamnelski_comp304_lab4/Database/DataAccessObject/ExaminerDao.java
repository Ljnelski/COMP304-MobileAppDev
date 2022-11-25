package com.example.liamnelski_comp304_lab4.Database.DataAccessObject;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.liamnelski_comp304_lab4.Database.Models.Examiner;

import java.util.List;

@Dao
public interface ExaminerDao {
    @Insert
    public void insert(Examiner examiner);

    @Update
    public void update(Examiner examiner);

    @Query("select * from examiner")
    public LiveData<List<Examiner>> getAll();
}

