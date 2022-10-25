package com.example.week6inclass;

import androidx.lifecycle.MutableLiveData;

public class Repository {
    private MutableLiveData<String> demoString = new MutableLiveData();

    public MutableLiveData<String> getDemoString() {
        setStringData();
        MutableLiveData<String> updateString = demoString;
        return updateString;
    }

    private void setStringData() {
        demoString.postValue("Hey Man, Nice Shot, I came from repository");
    }
}
