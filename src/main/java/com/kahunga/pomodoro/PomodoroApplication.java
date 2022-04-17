package com.kahunga.pomodoro;

import com.kahunga.pomodoro.dailyTracker.PomodoroCounter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;


@EnableJpaRepositories("com.kahunga.pomodoro.*")
@EntityScan(basePackageClasses= {PomodoroApplication.class, Jsr310JpaConverters.class})
@SpringBootApplication
public class PomodoroApplication {

	public static void main(String[] args) {
		SpringApplication.run(PomodoroApplication.class, args);
		PomodoroCounter pomodoroCounter = PomodoroCounter.createInstance();
		pomodoroCounter.startPomodoroCounter(1);
	}
}
