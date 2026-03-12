package GUI;

import java.awt.Color;

import javax.swing.JFrame;

public class HomeFrame extends JFrame {

    MainPanel mainPanel = new MainPanel(this);

    public HomeFrame() {
        super("Workout App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setUndecorated(true);
        setSize(1280, 720);
        setBackground(Color.GRAY);
        this.add(mainPanel);
        setVisible(true);
    }

}
