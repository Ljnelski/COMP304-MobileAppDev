package com.example.liamnelski_comp304_lab4.Database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.liamnelski_comp304_lab4.Database.DataAccessObject.ApplicantDao;
import com.example.liamnelski_comp304_lab4.Database.DataAccessObject.ExaminerDao;
import com.example.liamnelski_comp304_lab4.Database.DataAccessObject.TestDao;
import com.example.liamnelski_comp304_lab4.Database.Models.Applicant;
import com.example.liamnelski_comp304_lab4.Database.Models.Examiner;
import com.example.liamnelski_comp304_lab4.Database.Models.Test;

import java.util.List;

public class Repository {
    private LiveData<List<Examiner>> examiners;
    private LiveData<List<Applicant>> applicants;
    private LiveData<List<Test>> tests;
    private LiveData<List<Test>> filteredTests;

    private DrivingTestDataBase dataBase;

    public Repository(Context context) {
        dataBase = DrivingTestDataBase.getInstance(context.getApplicationContext());
        examiners = dataBase.examinerDao().getAll();
        applicants = dataBase.applicantDao().getAll();
        tests = dataBase.testDao().getAll();
        filteredTests = tests;
    }

    public void insertExaminer(Examiner newExaminer) {
         new InsertExaminerAsyncTask(dataBase.examinerDao()).execute(newExaminer);
    }

    public void insertApplicant(Applicant newApplicant) {
        new InsertApplicantAsyncTask(dataBase.applicantDao()).execute(newApplicant);
    }

    public void insertTest(Test newTest) {
        new InsertTestAsyncTask(dataBase.testDao()).execute(newTest);
    }

    public LiveData<List<Examiner>> getExaminers() {
        return examiners;
    }

    public LiveData<List<Applicant>> getApplicants() {
        return applicants;
    }

    public LiveData<List<Test>> getTests() { return tests; }

    public void updateApplicant(Applicant applicant) {
        new UpdateApplicantAsyncTask(dataBase.applicantDao()).execute(applicant);
    }

    static class InsertExaminerAsyncTask extends AsyncTask<Examiner, Void, Void> {
        private ExaminerDao examinerDao;
        private InsertExaminerAsyncTask(ExaminerDao drivingTestDAO) {
            this.examinerDao = drivingTestDAO;
        }

        @Override
        protected Void doInBackground(Examiner... examiners) {
            examinerDao.insert(examiners[0]);
            return null;
        }
    }

    static class InsertApplicantAsyncTask extends AsyncTask<Applicant, Void, Void> {
        private ApplicantDao applicantDao;
        private InsertApplicantAsyncTask(ApplicantDao drivingTestDAO) {
            this.applicantDao = drivingTestDAO;
        }

        @Override
        protected Void doInBackground(Applicant... applicants) {
            applicantDao.insert(applicants[0]);
            return null;
        }
    }

    static class InsertTestAsyncTask extends AsyncTask<Test, Void, Void> {
        private TestDao testDao;
        private InsertTestAsyncTask(TestDao testDao) {
            this.testDao = testDao;
        }

        @Override
        protected Void doInBackground(Test... tests) {
            testDao.insert(tests[0]);
            return null;
        }
    }

    static class UpdateApplicantAsyncTask extends AsyncTask<Applicant, Void, Void> {
        private ApplicantDao applicantDao;

        private UpdateApplicantAsyncTask(ApplicantDao applicantDao) {
            this.applicantDao = applicantDao;
        }

        @Override
        protected Void doInBackground(Applicant... applicants) {
            applicantDao.update(applicants[0]);
            return null;
        }
    }
}
