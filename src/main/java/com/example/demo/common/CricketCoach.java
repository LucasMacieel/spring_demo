package com.example.demo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

// @Component - Marks a class to be managed by Spring, being called as a "bean".
@Component
public class CricketCoach implements Coach {

    /*@PostConstruct - Called after bean creation.
    public void startUp() {
        System.out.println("In startUp(): " + getClass().getSimpleName());
    }

    @PreDestroy - Called after bean destruction.
    public void cleanUp() {
        System.out.println("In cleanUp(): " + getClass().getSimpleName());
    }*/

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes.";
    }
}
