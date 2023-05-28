package com.example.cwiczenia1;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("singleton")

public class ActivityDataBase {

    private List<Activity> activityList = new ArrayList<>();

    public List<Activity> getAllActivities() {
        return activityList;
    }
    public void addActivity(Activity activity){
        activityList.add(activity);
    }
    public void deleteAll(){
        activityList.clear();
    }
}
