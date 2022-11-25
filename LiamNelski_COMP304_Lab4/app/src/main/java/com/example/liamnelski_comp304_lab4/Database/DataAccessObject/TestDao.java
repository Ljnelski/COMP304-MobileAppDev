package com.example.liamnelski_comp304_lab4.Database.DataAccessObject;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.liamnelski_comp304_lab4.Database.Models.Test;

import java.util.List;

@Dao
public interface TestDao {
    @Insert
    public void insert(Test test);
    @Update
    public void update(Test test);

    @Query("select * from test")
    public LiveData<List<Test>> getAll();

    @Query("select * from test where applicant_id = :applicantId")
    public LiveData<List<Test>> getByApplicantId(int applicantId);
}
