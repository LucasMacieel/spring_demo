package com.example.demo.common;

import org.springframework.stereotype.Component;

// @Primary - Single use annotation, defines a bean to be used on injection. @Qualifier has higher priority.
// @Lazy - Bean is only initialized if needed for dependency injection.
@Component
public class TrackCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k!";
    }
}
