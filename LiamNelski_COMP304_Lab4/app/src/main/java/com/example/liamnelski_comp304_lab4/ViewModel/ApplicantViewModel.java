package com.example.liamnelski_comp304_lab4.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.liamnelski_comp304_lab4.Database.Models.Applicant;
import com.example.liamnelski_comp304_lab4.Database.Repository;

import java.util.List;

public class ApplicantViewModel extends AndroidViewModel {
    public Repository repository;
    public LiveData<List<Applicant>> applicants;


    public ApplicantViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
        applicants = repository.getApplicants();

    }

    public void update(Applicant applicant) {repository.updateApplicant(applicant); }

    public void insert(Applicant applicant) {
        repository.insertApplicant(applicant);
    }

    public LiveData<List<Applicant>> getApplicants() {
        return applicants;
    }
}
