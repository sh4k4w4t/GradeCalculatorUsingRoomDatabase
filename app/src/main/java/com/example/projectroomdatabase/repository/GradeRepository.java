package com.example.projectroomdatabase.repository;

import android.app.Application;
import android.os.AsyncTask;

import com.example.projectroomdatabase.db.GradeDatabase;
import com.example.projectroomdatabase.dao.CourseDao;
import com.example.projectroomdatabase.dao.SemisterDao;
import com.example.projectroomdatabase.model.Course;
import com.example.projectroomdatabase.model.Semister;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class GradeRepository {
    private CourseDao courseDao;
    private SemisterDao semisterDao;

    List<Semister> mySemisterList= new ArrayList<>();
    List<Course> myCourseList= new ArrayList<>();

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

    public void InsertCourseList(List<Course> courses){
        new CourseListTasks(courseDao).execute(courses);
    }

    public List<Course> ListOfCourseBySemisterId(int semisterId){
        try {
            myCourseList= new GetAllCourseUsingSemister(courseDao).execute(semisterId).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return myCourseList;
    }

    public void DeleteCourse(Course course){
        new CourseDeleteTask(courseDao).execute(course);
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

    private static class CourseListTasks extends AsyncTask<List<Course>,Void,Void>{
        CourseDao courseDao;
        CourseListTasks(CourseDao dao){
            courseDao= dao;
        }
        @Override
        protected Void doInBackground(List<Course>... lists) {
            courseDao.InsertCourseList(lists[0]);
            return null;
        }
    }

    private static class GetAllCourseUsingSemister extends AsyncTask<Integer,Void,List<Course>>{
        CourseDao courseDao;

        public GetAllCourseUsingSemister(CourseDao dao) {
            this.courseDao = dao;
        }

        @Override
        protected List<Course> doInBackground(Integer... integers) {
            return courseDao.GetCoursesBySemesterId(integers[0]);
        }
    }

    private static class CourseDeleteTask extends AsyncTask<Course, Void,Void>{
        CourseDao courseDao;

        public CourseDeleteTask(CourseDao courseDao) {
            this.courseDao = courseDao;
        }

        @Override
        protected Void doInBackground(Course... courses) {
            courseDao.DeleteCourse(courses[0]);
            return null;
        }
    }
}
