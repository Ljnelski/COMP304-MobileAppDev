package com.example.liamnelski_comp304_lab4.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.liamnelski_comp304_lab4.Database.Models.Test;
import com.example.liamnelski_comp304_lab4.Database.Repository;

import java.util.List;

public class TestViewModel extends AndroidViewModel {
    public Repository repository;
    public LiveData<List<Test>> tests;

    public TestViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
        tests = repository.getTests();
    }

    public void insert(Test test) {
        repository.insertTest(test);
    }

    public LiveData<List<Test>> getTests() {
        return tests;
    }
}
