package com.kahunga.pomodoro.dailyTracker;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@NoArgsConstructor
public class PomodoroCounter {
    private static PomodoroCounter pomodoroCounterInstance = null;
    private PomodoroTimer currentPomodoroTimer;
    @Autowired
    PomodoroRepository pomodoroRepository;

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
        Pomodoro pomodoro = new Pomodoro();
        pomodoro.setTimeStarted(timeStarted);
        pomodoro.setTimecompleted(timeCompleted);
        Pomodoro save = pomodoroRepository.save(pomodoro);
        log.info("save a pomodoro of id {}",save.getId());
    }
}
