package com.example.liamnelski_comp304_lab4.Database.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Test {

    @PrimaryKey
    private int id;

    @ColumnInfo(name = "applicant_id")
    private int applicantId;

    @ColumnInfo(name = "examiner_id")
    private int examinerId;

    @ColumnInfo(name = "test_result")
    private String testResult;

    @ColumnInfo(name = "test_date")
    private String testDate;

    @ColumnInfo(name = "test_route")
    private String testRoute;

    @ColumnInfo(name = "test_type")
    private String testType;

    public Test() {

    }

    @Ignore
    public Test(int id, int applicantId, int examinerId, String test_result, String testRoute, String testType, String testDate) {
        this.id = id;
        this.applicantId = applicantId;
        this.examinerId = examinerId;
        this.testResult = test_result;
        this.testRoute = testRoute;
        this.testType = testType;
        this.testDate = testDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(int applicantId) {
        this.applicantId = applicantId;
    }

    public int getExaminerId() {
        return examinerId;
    }

    public void setExaminerId(int examinerId) {
        this.examinerId = examinerId;
    }
    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public String getTestRoute() {
        return testRoute;
    }

    public void setTestRoute(String testRoute) {
        this.testRoute = testRoute;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public String getTestDate() {
        return testDate;
    }

    public void setTestDate(String testDate) {
        this.testDate = testDate;
    }
}

