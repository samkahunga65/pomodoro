package gui;
import javax.swing.JFrame;

public class Panel {
    private static Panel  panel = null;
    private static JFrame frame;

    private void Panel() {
    }

    public static Panel create() {
        if (panel == null) {
            frame = new JFrame("window");
            frame.setTitle("Pomodoro");
            frame.setSize(420, 420);
            frame.setVisible(true);
            panel = new Panel();
            return panel;
        } else {
            return panel;
        }
    }
    public static Panel create(String title) {
        create();
        frame.setTitle(title);
        return panel;
    }
}
