package com.example.cwiczenia1;

import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("test")
public class TestAPI {

    @Autowired
    private ActivityDataBase activityDataBase;

    @GetMapping("v1")
    public String test(){
        return "test";
    }
    @PostMapping(value = "activities", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void addActivity(@RequestBody Activity activity){
        activityDataBase.addActivity(activity);
    }

    @GetMapping(value = "activities", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Activity> getActivities(@Nullable @RequestParam("priority") Integer priority, @Nullable @RequestParam("name") String name){
        return activityDataBase.getAllActivities(priority, name);
    }

    @GetMapping(value = "activities/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getActivityById(@PathVariable("id") Integer id){
        Activity activity = activityDataBase.getActivitieById(id);
        if(activity == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(activity);
    }

    @DeleteMapping(value = "activities", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteActivities(){
        activityDataBase.deleteAll();
    }

    @DeleteMapping(value = "activities/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteActivitiesById(@PathVariable("id") Integer id){
        if(activityDataBase.deleteById(id)){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
