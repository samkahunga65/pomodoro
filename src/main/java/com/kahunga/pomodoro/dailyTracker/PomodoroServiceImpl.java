package com.kahunga.pomodoro.dailyTracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
public class PomodoroServiceImpl implements PomodoroService {
    @Autowired
    PomodoroRepository pomodoroRepository;

    @Override
    @Transactional
    public Pomodoro savePomodoro(LocalDateTime timeStarted, LocalDateTime timeCompleted) {
        return pomodoroRepository.save(new Pomodoro(timeStarted, timeCompleted));
    }

    @Override
    @Transactional
    public Pomodoro savePomodoro(LocalDateTime timeStarted, LocalDateTime timeCompleted, String message) {
        return pomodoroRepository.save(new Pomodoro(timeStarted, timeCompleted, message));
    }
}
