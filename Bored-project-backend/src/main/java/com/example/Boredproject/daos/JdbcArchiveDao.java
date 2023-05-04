package com.example.Boredproject.daos;

import com.example.Boredproject.models.Activity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcArchiveDao implements ArchiveDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcArchiveDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Activity> getArchivedActivities(){
        String sql = " SELECT * FROM archive ";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        List<Activity> archiveList = new ArrayList<>();
        while(result.next()){
            archiveList.add(mapRowToActivity(result));
        }
        return archiveList;
    }

    @Override
    public boolean addActivityToArchive(Activity activity){
        String sql = " INSERT INTO archive (activity_id, activity, activity_type, participants, price, activity_key) " +
                    " VALUES(?, ?, ?, ?, ?, ?) ";

        return jdbcTemplate.update(sql, activity.getActivityId(),
                activity.getActivity(), activity.getType(),
                activity.getParticipants(), activity.getPrice(), activity.getKey()) ==1;

    }

    private Activity mapRowToActivity(SqlRowSet result){
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
