package com.kahunga.pomodoro.dailyTracker;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Connector {
    @Bean
    PomodoroTimer pomodoroTimer() {
        return new PomodoroTimer();
    }
    @Bean
    PomodoroCounter pomodoroCounter() {
        return new PomodoroCounter();
    }
}
