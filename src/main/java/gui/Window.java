package gui;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    Window() {
        this.setTitle("Pomodoro");
        this.setSize(420,420);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(123,50,250));
    }
    Window(String title) {
        new Window();
        this.setTitle(title);
    }
}
