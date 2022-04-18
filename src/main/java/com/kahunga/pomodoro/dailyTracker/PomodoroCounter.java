package com.kahunga.pomodoro.dailyTracker;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDateTime;

@Slf4j
@NoArgsConstructor
public class PomodoroCounter {
    private static PomodoroCounter pomodoroCounterInstance = null;
    private PomodoroTimer currentPomodoroTimer;
    @Autowired
    PomodoroServiceImpl pomodoroService;

    public static PomodoroCounter createInstance() {
        if (pomodoroCounterInstance==null) {
            pomodoroCounterInstance = new PomodoroCounter();
        }
        return pomodoroCounterInstance;
    }
    public void startPomodoroCounter(int pomodoroLengthInMinutes) {
        currentPomodoroTimer = new PomodoroTimer();
        currentPomodoroTimer.start();
        log.info("Started counter");
    }
    public void pausePomodoroCounter() {
        currentPomodoroTimer.pause();
    }
    public void continuePomodoroCounter() {
        currentPomodoroTimer.continueCounting();
    }

    public void savePomodoro(LocalDateTime timeStarted, LocalDateTime timeCompleted) {
        Pomodoro save = pomodoroService.savePomodoro(timeStarted, timeCompleted);
        log.info("save a pomodoro of id {}",save.getId());
    }
}
