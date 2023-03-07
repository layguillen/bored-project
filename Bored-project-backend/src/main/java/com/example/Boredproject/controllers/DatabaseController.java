package com.example.Boredproject.controllers;

import com.example.Boredproject.daos.ActivityDao;
import com.example.Boredproject.models.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class DatabaseController {

    @Autowired
    private ActivityDao activityDao;
    @PostMapping("/add-activity")
    @ResponseStatus(HttpStatus.CREATED) //returns a 201 status
    public Activity addActivityToDatabase(@RequestBody Activity activity){
        return activityDao.addActivity(activity);
    }
    
    @GetMapping("/all-activities")
    public List<Activity> getActivitiesFromDatabase(){
        return activityDao.getAllActivities();
    }
}
