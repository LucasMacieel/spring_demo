package com.example.demo.rest;

import com.example.demo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class DemoController {

    @Value("${coach.name}") // Gets a value set on the application.properties file.
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    private Coach myCoach;
    private Coach anotherCoach;

    // Constructor injection
    // @Autowired - Automatically creates objects and inject dependencies.
    // @Qualifier - Determines the implementation that will be used.
    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach myCoach, @Qualifier("cricketCoach") Coach anotherCoach) {
        this.myCoach = myCoach;
        this.anotherCoach = anotherCoach;
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

    // The default bean scope is singleton, meaning only one instance of the bean will be created and reused.
    // The prototype scope creates a new bean instance for each container request.
    // Singleton - myCoach == anotherCoach: true
    // Prototype - myCoach == anotherCoach: false
    @GetMapping("/check")
    public String check() {
        return "Comparing beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
    }
}
