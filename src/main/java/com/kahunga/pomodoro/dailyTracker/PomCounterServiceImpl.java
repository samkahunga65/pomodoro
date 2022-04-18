package com.kahunga.pomodoro.dailyTracker;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class PomCounterServiceImpl implements PomCounterService{
    private PomodoroTimer currentPomodoroTimer;

    @Autowired
    PomodoroServiceImpl pomodoroService;

    @Override
    public void startPomodoroCounter(int pomodoroLengthInMinutes) {
        currentPomodoroTimer = new PomodoroTimer();
        currentPomodoroTimer.start();
        log.info("Started counter");
    }

    @Override
    public void pausePomodoroCounter() {

    }

    @Override
    public void continuePomodoroCounter() {

    }

    @Override
    public Pomodoro savePomodoro(LocalDateTime timeStarted, LocalDateTime timeCompleted) {
        var save =  pomodoroService.savePomodoro(timeStarted, timeCompleted);
        log.info("save a pomodoro of id {}",save.getId());
        return save;
    }
}
