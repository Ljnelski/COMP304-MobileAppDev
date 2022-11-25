package com.example.liamnelski_comp304_lab4.Database.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Applicant {
    @PrimaryKey
    private int id;

    @ColumnInfo(name = "first_name")
    private String firstName;

    @ColumnInfo(name = "last_name")
    private String lastName;

    @ColumnInfo(name = "test_centre")
    private String testCentre;

    @ColumnInfo(name = "examiner_id")
    private int examinerId;

    public Applicant() {

    }

    @Ignore
    public Applicant(int id) {
        this.id = id;
        this.firstName = "UNDEFINED";
        this.lastName = "UNDEFINED";
        this.testCentre = "UNDEFINED";
    }
    @Ignore
    public Applicant(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.testCentre = "UNDEFINED";
    }
    @Ignore
    public Applicant(int id, String firstName, String lastName, String testCentre, int examinerId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.testCentre = testCentre;
        this.examinerId = examinerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTestCentre() {
        return testCentre;
    }

    public void setTestCentre(String testCentre) {
        this.testCentre = testCentre;
    }

    public int getExaminerId() {
        return examinerId;
    }

    public void setExaminerId(int examinerId) {
        this.examinerId = examinerId;
    }
}
