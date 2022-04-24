package com.kahunga.pomodoro;

import gui.Panel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;


@SpringBootApplication(scanBasePackages = {"com.kahunga.pomodoro"})
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.kahunga.pomodoro"})
public class PomodoroApplication implements CommandLineRunner {
	@Autowired
	PomodoroManager pomodoroManager;
	@Autowired
	private ConfigurableApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(PomodoroApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Panel panel = Panel.create();
	}
}
