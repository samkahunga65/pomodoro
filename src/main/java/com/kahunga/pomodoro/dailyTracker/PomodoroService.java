package com.kahunga.pomodoro.dailyTracker;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

public interface PomodoroService {
    Pomodoro savePomodoro(LocalDateTime timeStarted, LocalDateTime timeCompleted);
    Pomodoro savePomodoro(LocalDateTime timeStarted, LocalDateTime timeCompleted, String message);
}
