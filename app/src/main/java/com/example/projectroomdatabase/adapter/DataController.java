package com.example.projectroomdatabase.adapter;

public class DataController {
    public static DataController instance;
    public static DataController getInstance(){
        if (instance == null){
            instance= new DataController();
        }
        return instance;
    }
    HomeFragmentInterface homeFragmentInterface;

    public HomeFragmentInterface getHomeFragmentInterface() {
        return homeFragmentInterface;
    }

    public void setHomeFragmentInterface(HomeFragmentInterface homeFragmentInterface) {
        this.homeFragmentInterface = homeFragmentInterface;
    }
}
