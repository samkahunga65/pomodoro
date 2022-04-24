package com.kahunga.pomodoro;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PomodoroManager {
    private static PomodoroManager pomodoroManagerCreated = null;

    @Autowired
    PomodoroTimer pomodoroTimer;

    public void startPomodoroCounter() {
        pomodoroTimer.start();
    }

}
