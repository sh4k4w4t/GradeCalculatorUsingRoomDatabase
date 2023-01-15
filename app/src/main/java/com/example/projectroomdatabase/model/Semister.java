package com.example.projectroomdatabase.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity
public class Semister {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String semisterName;
    public double semisterCredit;

    public Semister(String semisterName, double semisterCredit) {
        this.semisterName = semisterName;
        this.semisterCredit = semisterCredit;
    }

    public String getSemisterName() {
        return semisterName;
    }

    public void setSemisterName(String semisterName) {
        this.semisterName = semisterName;
    }

    public double getSemisterCredit() {
        return semisterCredit;
    }

    public void setSemisterCredit(double semisterCredit) {
        this.semisterCredit = semisterCredit;
    }
}
