package com.example.Boredproject.controllers;

import com.example.Boredproject.models.Activity;
import com.example.Boredproject.services.BoredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class BoredController {

    //@Autowired is a SpringBoot annotation that injects dependencies (service) for us = don't need a constructor
    @Autowired
    BoredService service;

    @GetMapping("/activity")
    public Activity getActivity(){
        return service.loadActivity();
    }

    @GetMapping("/activity/{type}")
    public Activity getActivityByType(@PathVariable String type){
        return service.loadActivityByType(type);
    }


}
