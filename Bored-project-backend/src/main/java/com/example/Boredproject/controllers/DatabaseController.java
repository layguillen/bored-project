package com.example.Boredproject.controllers;

import com.example.Boredproject.daos.ActivityDao;
import com.example.Boredproject.daos.ArchiveDao;
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

    @Autowired
    private ArchiveDao archiveDao;

    @PostMapping("/add-activity")
    @ResponseStatus(HttpStatus.CREATED) //returns a 201 status
    public Activity addActivityToDatabase(@RequestBody Activity activity){

        return activityDao.addActivity(activity);
    }

    @GetMapping("/all-activities")
    public List<Activity> getActivitiesFromDatabase(){
        return activityDao.getAllActivities();
    }

    @DeleteMapping("/delete/{key}")
    public void deleteActivity(@PathVariable int key){
        activityDao.deleteActivity(key);
    }


    @PostMapping("/add-archive")
    @ResponseStatus(HttpStatus.CREATED) //returns a 201 status
    public boolean addActivityToArchive(@RequestBody Activity activity){
        return archiveDao.addActivityToArchive(activity);
    }

    @GetMapping("/archived-activities")
    public List<Activity> getArchivedActivitiesFromDb(){
        return archiveDao.getArchivedActivities();
    }

}
