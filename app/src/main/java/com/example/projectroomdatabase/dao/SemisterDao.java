package com.example.projectroomdatabase.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.projectroomdatabase.model.Semister;

import java.util.List;

@Dao
public interface SemisterDao {
    @Insert
    void InsertSemister(Semister semister);

    @Update
    void UpdateSemister(Semister semister);

    @Delete
    void DeleteSemister(Semister semister);

    @Query("select * from Semister order by id ASC")
    List<Semister> GetAllSemisters();

}
