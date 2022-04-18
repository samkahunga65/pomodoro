package com.kahunga.pomodoro.dailyTracker;

import java.time.LocalDateTime;

public interface PomCounterService {
    void startPomodoroCounter(int pomodoroLengthInMinutes);
    void pausePomodoroCounter();
    void continuePomodoroCounter();
    Pomodoro savePomodoro(LocalDateTime timeStarted, LocalDateTime timeCompleted);
}
