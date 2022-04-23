package com.kahunga.pomodoro;

public class PomodoroManager {
    private static PomodoroManager pomodoroManagerCreated = null;

    private PomodoroManager() {

    }
    public static PomodoroManager create() {
        if (pomodoroManagerCreated == null) {
            return new PomodoroManager();
        } else {
            return pomodoroManagerCreated;
        }
    }


}
