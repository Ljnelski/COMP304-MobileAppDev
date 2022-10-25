package com.example.week6inclass;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DemoViewModel extends ViewModel {
    private MutableLiveData<String> demoString = new MutableLiveData();

    // define init() method
    public void init() {
        // Repository repository = new Repository();
        Repository_LiveData repository_liveData = new Repository_LiveData();
        demoString = repository_liveData.getDemoString();
        // demoString = repository.getDemoString();
    }

    // create a method to be called by View (MainActivity)
    public LiveData<String> getDemoString() {
        return demoString;
    }
}
