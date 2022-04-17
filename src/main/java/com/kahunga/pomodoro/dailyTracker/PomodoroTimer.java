package com.kahunga.pomodoro.dailyTracker;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

@Slf4j
@Setter
public class PomodoroTimer {
    private Timer timer = new Timer();
    private TimerTask timerTask;
    private Long timerLength = 1000L;
    private LocalDateTime originalTimeStarted = LocalDateTime.now();
    private LocalDateTime originalScheduledEnd = originalTimeStarted.plus(timerLength, ChronoUnit.MILLIS);
    private LocalDateTime timeStarted = LocalDateTime.now();
    private PomodoroCounter pomodoroCounter = PomodoroCounter.createInstance();
    public void start() {
        this.timerTask = new TimerTask() {
            @Override
            public void run() {
                pomodoroCounter.savePomodoro(timeStarted, LocalDateTime.now());
            }
        };
        timer.schedule(this.timerTask, timerLength);
    }
    public void pause() {
        this.timerLength = ChronoUnit.MILLIS.between(originalTimeStarted, LocalDateTime.now());
        log.info("new timer length is {} minutes ", TimeUnit.MILLISECONDS.toMinutes(timerLength));
        timer.cancel();
    }
    public void continueCounting() {
        this.timerTask = new TimerTask() {
            @Override
            public void run() {
                pomodoroCounter.savePomodoro(timeStarted, LocalDateTime.now());
            }
        };
        timer.schedule(this.timerTask, timerLength);
    }

}
