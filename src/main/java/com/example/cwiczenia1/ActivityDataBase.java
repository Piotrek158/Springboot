package com.example.cwiczenia1;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("singleton")

public class ActivityDataBase {

    private List<Activity> activityList = new ArrayList<>();
    private int activityIndex = 1;


    public List<Activity> getAllActivities() {
        return activityList;
    }

    public List<Activity> getAllActivities(Integer priority, String name) {
        if(priority==null && name==null){
            return activityList;
        }
        List<Activity> filteredActivities = new ArrayList<>();

        if (priority == null || name == null){
            for (Activity activity : activityList){
                if (activity.getPriority().equals(priority) || activity.getName().equals(name)){
                    filteredActivities.add(activity);
                }
            }
        } else {
            for (Activity activity : activityList) {
                if (activity.getPriority().equals(priority) && activity.getName().equals(name)) {
                    filteredActivities.add(activity);
                }
            }
        }
        return filteredActivities;
    }

    public void addActivity(Activity element){
        element.setId(activityIndex);
        activityList.add(element);
        activityIndex = activityIndex+1;
    }
    public void deleteAll(){
        activityList.clear();
    }

    public Activity getActivitieById(Integer id) {
        for(Activity element : activityList){
            if(element.getId().equals(id)){
                return element;
            }
        }
        return null;
    }

    public boolean deleteById(Integer id) {
        Activity activityToDelete = null;
        for(Activity element : activityList){
            if(element.getId().equals(id)) {
                activityToDelete = element;
            }
        }
        if(activityToDelete == null){
            return false;
        } else {
            activityList.remove(activityToDelete);
            return true;
        }
    }
}
