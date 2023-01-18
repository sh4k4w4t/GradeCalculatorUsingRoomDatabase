package com.example.projectroomdatabase.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.projectroomdatabase.model.Course;

import java.util.List;

@Dao
public interface CourseDao {
    @Insert
    void InsertCourse(Course course);

    @Delete
    void DeleteCourse(Course course);

    @Update
    void UpdateCourse(Course course);

    @Query("select * from Course where semisterId Like :semisterId")
    List<Course> GetCoursesBySemesterId(int semisterId);

    @Insert
    void InsertCourseList(List<Course> courses);

    @Query("Delete from Course")
    void DeleteAllCourses();
}
