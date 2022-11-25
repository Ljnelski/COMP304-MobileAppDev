package com.example.liamnelski_comp304_lab4.Database.DataAccessObject;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.liamnelski_comp304_lab4.Database.Models.Applicant;

import java.util.List;

@Dao
public interface ApplicantDao {
    @Insert
    public void insert(Applicant examiner);

    @Update
    public void update(Applicant examiner);

    @Query("select * from applicant")
    public LiveData<List<Applicant>> getAll();
}
