package com.kahunga.pomodoro.dailyTracker;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.boot.context.properties.ConstructorBinding;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pomodoro")
public class Pomodoro {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "timeStarted")
    private LocalDateTime timeStarted;

    @NotNull
    @Column(name = "timeCompleted")
    private LocalDateTime timecompleted;

    @Column(name = "message")
    private String message;
}
