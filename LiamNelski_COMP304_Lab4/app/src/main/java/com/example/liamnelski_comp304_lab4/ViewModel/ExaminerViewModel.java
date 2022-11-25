package com.example.liamnelski_comp304_lab4.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.liamnelski_comp304_lab4.Database.Repository;
import com.example.liamnelski_comp304_lab4.Database.Models.Examiner;
import com.example.liamnelski_comp304_lab4.Database.Models.Test;

import java.util.List;

public class ExaminerViewModel extends AndroidViewModel {
    public Repository repository;
    public LiveData<List<Examiner>> examiners;

    public ExaminerViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
        examiners = repository.getExaminers();
    }

    public void insert(Examiner examiner) {
        repository.insertExaminer(examiner);
    }

    public LiveData<List<Examiner>> getExaminers() {
        return examiners;
    }

}

