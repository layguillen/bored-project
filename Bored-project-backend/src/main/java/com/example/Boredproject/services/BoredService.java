package com.example.Boredproject.services;

import com.example.Boredproject.models.Activity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BoredService {
    //@Value annotation allows us to grab the values from application.properties
    @Value("${BORED_API}")
    private String BORED_API;

    //RestTemplate is how we communicate with API
    RestTemplate restTemplate = new RestTemplate();

    public Activity loadActivity(){
        ResponseEntity<Activity> responseEntity =
                restTemplate.exchange(BORED_API, HttpMethod.GET, makeEntity(), Activity.class);
        Activity activity = responseEntity.getBody();
        return activity;
    }

    private HttpEntity<Void> makeEntity(){
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Void> entity = new HttpEntity<>(headers);
        return entity;
    }
}
