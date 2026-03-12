package GUI;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainPanel extends JPanel{
    
    HomePanel buttonPanel;
    ExitPanel exitPanel;
    public MainPanel(JFrame frame) {
        exitPanel = new ExitPanel(frame, this);
        buttonPanel = new HomePanel(frame, this);

        setBackground(Color.RED);
        add(buttonPanel);
        setVisible(true);
    }

    public void showExitPanel() {
                add(exitPanel);

        exitPanel.setVisible(true);
    }

    public void showButtonPanel() {
        buttonPanel.setVisible(true);
    }
}
