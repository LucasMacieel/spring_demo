package com.example.demo.config;

import com.example.demo.common.Coach;
import com.example.demo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean // Make classes not annotated with @Component a spring bean. The default bean id is the method name.
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
