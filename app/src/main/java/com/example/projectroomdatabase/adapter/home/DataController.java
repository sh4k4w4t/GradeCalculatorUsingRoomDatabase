package com.example.projectroomdatabase.adapter.home;

import com.example.projectroomdatabase.model.Semister;

public class DataController {
    public static DataController instance;
    public static DataController getInstance(){
        if (instance == null){
            instance= new DataController();
        }
        return instance;
    }


    HomeFragmentInterface homeFragmentInterface;
    Semister currentSemister;

    //getter setter
    public HomeFragmentInterface getHomeFragmentInterface() {
        return homeFragmentInterface;
    }

    public void setHomeFragmentInterface(HomeFragmentInterface homeFragmentInterface) {
        this.homeFragmentInterface = homeFragmentInterface;
    }

    public Semister getCurrentSemister() {
        return currentSemister;
    }

    public void setCurrentSemister(Semister currentSemister) {
        this.currentSemister = currentSemister;
    }
}
