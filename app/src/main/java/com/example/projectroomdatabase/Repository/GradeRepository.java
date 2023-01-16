package com.example.projectroomdatabase.Repository;

import android.app.Application;
import android.os.AsyncTask;

import com.example.projectroomdatabase.DB.GradeDatabase;
import com.example.projectroomdatabase.dao.CourseDao;
import com.example.projectroomdatabase.dao.SemisterDao;
import com.example.projectroomdatabase.model.Semister;

public class GradeRepository {
    private CourseDao courseDao;
    private SemisterDao semisterDao;

    public GradeRepository(Application application){
        GradeDatabase database= GradeDatabase.getDatabase(application);
        courseDao= database.courseDao();
        semisterDao= database.semisterDao();
    }

    public void InsertSemister(Semister semister){
        new InsertTasks(semisterDao).execute(semister);
    }

    private static class InsertTasks extends AsyncTask<Semister,Void,Void>{
        private SemisterDao dao;
        InsertTasks(SemisterDao semisterDao){
            dao=semisterDao;
        }
        @Override
        protected Void doInBackground(Semister... semisters) {
            dao.InsertSemister(semisters[0]);
            return null;
        }
    }

}
