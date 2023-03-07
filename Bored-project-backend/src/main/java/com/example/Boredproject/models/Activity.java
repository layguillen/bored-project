package com.example.Boredproject.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Activity {
    private int activityId;
    @JsonProperty("activity")
    private String activity;
    @JsonProperty("type")
    private String type;
    @JsonProperty("participants")
    private int participants;
    @JsonProperty("price")
    private double price;
    @JsonProperty("key")
    private int key;

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getParticipants() {
        return participants;
    }

    public void setParticipants(int participants) {
        this.participants = participants;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price * 100;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
