package com.example.demo.rest;

import com.example.demo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Value("${coach.name}") // Gets a value set on the application.properties file.
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    private Coach myCoach;

    // Constructor injection
    // @Autowired - Automatically creates objects and inject dependencies.
    // @Qualifier - Determines the implementation that will be used.
    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach myCoach) {
        this.myCoach = myCoach;
    }

    // Setter injection
    /*
    @Autowired
    public void setCoach(Coach myCoach) {
        this.myCoach = myCoach;
    }
    */

    @GetMapping("/")
    public String sayHello() {
        return "Hello World!";
    }

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/teamInfo")
    public String getTeamInfo() {
        return String.format("Coach: %s, Team Name: %s", coachName, teamName);
    }
}
