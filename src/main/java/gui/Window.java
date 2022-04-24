package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements ActionListener {
    JButton button;
    Window() {
        button = new JButton("Wohoo");
        button.setBounds(new Rectangle(30, 10));
        button.addActionListener(al -> System.out.println(al.toString()));
        this.setTitle("Pomodoro");
        this.setSize(420,420);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(123,50,250));
        this.add(button);
    }
    Window(String title) {
        this();
        this.setTitle(title);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
