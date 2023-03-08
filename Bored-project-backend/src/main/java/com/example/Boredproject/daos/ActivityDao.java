package com.example.Boredproject.daos;

import com.example.Boredproject.models.Activity;

import java.util.List;

public interface ActivityDao {

    Activity loadActivity();

    Activity addActivity(Activity activity);

    Activity getActivityById(int id);

    List<Activity> getAllActivities();

    void deleteActivity(int activityKey);
}
