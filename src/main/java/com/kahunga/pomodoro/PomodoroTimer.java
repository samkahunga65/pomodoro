package com.kahunga.pomodoro;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class PomodoroTimer {
    private Timer timer = new Timer();
    private TimerTask timerTask;
    private Long timerLength = 1000L;
    private LocalDateTime originalTimeStarted = LocalDateTime.now();
    private LocalDateTime originalScheduledEnd = originalTimeStarted.plus(timerLength, ChronoUnit.MILLIS);
    private LocalDateTime timeStarted;

    @Autowired
    PomodoroRepository pomodoroRepository;

    @Transactional
    public void start() {
        this.timerTask = new TimerTask() {
            @Override
            public void run() {
                log.info("pom com");
                Pomodoro pomodoro = new Pomodoro();
                pomodoro.setStartTime(originalTimeStarted);
                pomodoro.setEndTime(LocalDateTime.now());
                Pomodoro savedPom = pomodoroRepository.save(pomodoro);
                log.info("saved pomodoro id : ", savedPom.getId().toString());
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
        timeStarted = LocalDateTime.now();
        this.timerTask = new TimerTask() {
            @Override
            public void run() {
                log.info("pom com");
                Pomodoro pomodoro = new Pomodoro();
                pomodoro.setStartTime(timeStarted);
                pomodoro.setEndTime(LocalDateTime.now());
                pomodoroRepository.save(pomodoro);
            }
        };
        timer.schedule(this.timerTask, timerLength);
    }

}
