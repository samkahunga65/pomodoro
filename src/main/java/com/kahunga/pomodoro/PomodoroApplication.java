package com.kahunga.pomodoro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.kahunga.pomodoro"})
public class PomodoroApplication {

	public static void main(String[] args) {
		SpringApplication.run(PomodoroApplication.class, args);
	}

}
