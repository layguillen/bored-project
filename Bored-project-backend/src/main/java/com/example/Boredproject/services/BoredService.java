package com.example.Boredproject.services;

import com.example.Boredproject.models.Activity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

public class BoredService {
    //@Value annotation allows us to grab the values from application.properties
    @Value("${BORED_API}")
    private String BORED_API;

    //RestTemplate is how we communicate with API
    RestTemplate restTemplate = new RestTemplate();

    public Activity getActivity(){
        return null;
    }
}
