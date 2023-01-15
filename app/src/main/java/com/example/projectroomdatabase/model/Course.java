package com.example.projectroomdatabase.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Course {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String CourseName;
    public double courseGpa;
    public double courseCredit;
    public int semisterId;

    public Course(int id, String courseName, double courseGpa, double courseCredit, int semisterId) {
        this.id = id;
        CourseName = courseName;
        this.courseGpa = courseGpa;
        this.courseCredit = courseCredit;
        this.semisterId = semisterId;
    }

    public int getSemisterId() {
        return semisterId;
    }

    public void setSemisterId(int semisterId) {
        this.semisterId = semisterId;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public double getCourseGpa() {
        return courseGpa;
    }

    public void setCourseGpa(double courseGpa) {
        this.courseGpa = courseGpa;
    }

    public double getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(double courseCredit) {
        this.courseCredit = courseCredit;
    }
}
