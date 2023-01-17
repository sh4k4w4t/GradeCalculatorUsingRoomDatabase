package com.example.projectroomdatabase.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.projectroomdatabase.dao.CourseDao;
import com.example.projectroomdatabase.dao.SemisterDao;
import com.example.projectroomdatabase.model.Course;
import com.example.projectroomdatabase.model.Semister;

@Database(entities = {Course.class, Semister.class}, version = 1, exportSchema = false)
public abstract class GradeDatabase extends RoomDatabase {

    public abstract CourseDao courseDao();
    public abstract SemisterDao semisterDao();

    public static volatile GradeDatabase INSTANCE;

    public static GradeDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            GradeDatabase.class,
                            "GRADEDATABASE")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }

}
