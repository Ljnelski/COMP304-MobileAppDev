package com.example.liamnelski_comp304_lab4.Database.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Examiner {



    @PrimaryKey
    private int id;

    @ColumnInfo(name = "user_name")
    private String username;

    @ColumnInfo(name = "first_name")
    private String firstName;

    @ColumnInfo(name = "last_name")
    private String lastName;

    @ColumnInfo(name = "testCenter")
    private String testCentre;

    @ColumnInfo(name = "password")
    private String password;

    public Examiner() {

    }

    @Ignore
    public Examiner(int id) {
        this.id = id;
        this.username = "UNDEFINED";
        this.firstName = "UNDEFINED";
        this.lastName = "UNDEFINED";
        this.testCentre = "UNDEFINED";
        this.password = "PASSWORD";
    }
    @Ignore
    public Examiner(int id, String firstName, String lastName) {
        this.id = id;
        this.username = "UNDEFINED";
        this.firstName = firstName;
        this.lastName = lastName;
        this.testCentre = "UNDEFINED";
        this.password = "PASSWORD";
    }
    @Ignore
    public Examiner(int id, String firstName, String lastName, String testCentre, String username, String password) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.testCentre = testCentre;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
