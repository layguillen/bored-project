package com.example.Boredproject.daos;

import com.example.Boredproject.models.Activity;

import java.util.List;

public interface ArchiveDao {

    public List<Activity> getArchivedActivities();

    public boolean addActivityToArchive(Activity activity);
}
