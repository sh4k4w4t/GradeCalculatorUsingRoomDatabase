package com.example.projectroomdatabase.repository;

import android.app.Application;
import android.os.AsyncTask;

import com.example.projectroomdatabase.db.GradeDatabase;
import com.example.projectroomdatabase.dao.CourseDao;
import com.example.projectroomdatabase.dao.SemisterDao;
import com.example.projectroomdatabase.model.Semister;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class GradeRepository {
    private CourseDao courseDao;
    private SemisterDao semisterDao;

    List<Semister> mySemisterList= new ArrayList<>();

    public GradeRepository(Application application){
        GradeDatabase database= GradeDatabase.getDatabase(application);
        courseDao= database.courseDao();
        semisterDao= database.semisterDao();
    }

    public void InsertSemister(Semister semister){
        new InsertTasks(semisterDao).execute(semister);
    }

    public List<Semister> GetAllSemisters(){
        try {
            mySemisterList= new GelAllSemisterTask(semisterDao).execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return mySemisterList;
    }




    //backgroud task
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

    private static class GelAllSemisterTask extends AsyncTask<Void,Void,List<Semister>>{
        SemisterDao dao;
        GelAllSemisterTask(SemisterDao semisterDao){
            dao=semisterDao;
        }

        @Override
        protected List<Semister> doInBackground(Void... voids) {
            return dao.GetAllSemisters();
        }
    }

}
