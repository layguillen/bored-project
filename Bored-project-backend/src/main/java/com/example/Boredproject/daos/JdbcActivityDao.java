package com.example.Boredproject.daos;

import com.example.Boredproject.models.Activity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcActivityDao implements ActivityDao{
    private JdbcTemplate jdbcTemplate;

    @Override
    public Activity loadActivity() {
        return null;
    }

    @Override
    public Activity addActivity(Activity activity) {
        String sql= " INSERT INTO activity (activity, activity_type, participants, price, activity_key) " +
                    " VALUES(?, ?, ?, ?, ?) " +
                    " RETURNING activity_id ";
        Integer id = jdbcTemplate.queryForObject(sql, Integer.class, activity.getActivity(), activity.getType(),
                activity.getParticipants(), activity.getPrice(), activity.getKey());


        return getActivityById(id); //verify that the movie object was written to the db
    }

    @Override
    public Activity getActivityById(int id) {
        String sql = " SELECT * FROM activity WHERE activity_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);
        if(result.next()){
            return mapRowToMovie(result);
        }

        return null;
    }

    @Override
    public List<Activity> getAllActivities() {
        String sql = " SELECT * FROM activity ";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        List<Activity> activityList = new ArrayList<>();
        while(result.next()){
            activityList.add(mapRowToMovie(result));
        }

        return activityList;
    }

    private Activity mapRowToMovie(SqlRowSet result){
        Activity activity = new Activity();
        activity.setActivityId(result.getInt("activity_id"));
        activity.setActivity(result.getString("activity"));
        activity.setType(result.getString("activity_type"));
        activity.setParticipants(result.getInt("participants"));
        activity.setPrice(result.getDouble("price"));
        activity.setKey(result.getInt("activity_key"));

        return activity;
    }

}
