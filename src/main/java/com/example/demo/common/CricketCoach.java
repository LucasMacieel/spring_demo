package com.example.demo.common;

import org.springframework.stereotype.Component;

// @Component - Marks a class to be managed by Spring, being called as a "bean".
@Component
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes.";
    }
}
