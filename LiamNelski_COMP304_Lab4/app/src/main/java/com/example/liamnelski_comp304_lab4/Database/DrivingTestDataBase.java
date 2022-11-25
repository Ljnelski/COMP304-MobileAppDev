package com.example.liamnelski_comp304_lab4.Database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.liamnelski_comp304_lab4.Database.DataAccessObject.ApplicantDao;
import com.example.liamnelski_comp304_lab4.Database.DataAccessObject.ExaminerDao;
import com.example.liamnelski_comp304_lab4.Database.DataAccessObject.TestDao;
import com.example.liamnelski_comp304_lab4.Database.Models.Applicant;
import com.example.liamnelski_comp304_lab4.Database.Models.Examiner;
import com.example.liamnelski_comp304_lab4.Database.Models.Test;

@Database(entities = {Applicant.class, Examiner.class, Test.class}, version = 8)
public abstract class DrivingTestDataBase extends RoomDatabase {
    private static DrivingTestDataBase instance;

    public abstract ExaminerDao examinerDao();
    public abstract ApplicantDao applicantDao();
    public abstract TestDao testDao();

    public static synchronized DrivingTestDataBase getInstance(Context context) {
        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    DrivingTestDataBase.class, "driving_test_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallBack)
                    .build();
        }

        return  instance;
    }

    private static RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {

        private ExaminerDao examinerDao;
        private ApplicantDao applicantDao;
        private TestDao testDao;

        private PopulateDbAsyncTask(DrivingTestDataBase database) {
            examinerDao = database.examinerDao();
            applicantDao = database.applicantDao();
            testDao = database.testDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            examinerDao.insert(new Examiner(0,  "Liam", "Nelski", "Newmarket","Nelskii23", "MOBILEAPPDEV"));
            examinerDao.insert(new Examiner(1, "Glen",  "Turnbull", "Newmarket", "Glenster21", "PASSWORD56"));
            examinerDao.insert(new Examiner(2, "William", "Nelson", "Newmarket","Willy454",  "PASSWORD789"));

            applicantDao.insert(new Applicant(0, "Brad", "Dumbbigtruck", "Newmarket", 1));
            applicantDao.insert(new Applicant(1, "Sarah", "Doesnsee", "Newmarket", 1));
            applicantDao.insert(new Applicant(2, "Andrew", "inaloudsubaru", "Newmarket", 1));

            testDao.insert(new Test(0, 1, 1, "PASSED", "1A-12", "G2", "2022/08/23"));

            return null;
        }
    }
}
