package GUI;

import java.awt.Color;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainPanel extends JPanel{
    
    HomePanel buttonPanel;
    ExitPanel exitPanel;
    ReloadPanel reloadPanel;
    File exerciseListData;
    File workoutListData;

    public MainPanel(JFrame frame) {
        exerciseListData = new File("data/exerciseListData.json");
        workoutListData = new File("data/workoutListData.json");
        exitPanel = new ExitPanel(frame, this);
        buttonPanel = new HomePanel(frame, this);
        reloadPanel = new ReloadPanel(frame, this);

        setBackground(Color.RED);

        if(!exerciseListData.exists() && !workoutListData.exists()) {
            add(buttonPanel);
            setVisible(true);
        } else {
            add(reloadPanel);
            setVisible(true);
        }
    }

    public void showExitPanel() {
        add(exitPanel);
        exitPanel.setVisible(true);
    }

    public void showButtonPanel() {
        add(buttonPanel);
        buttonPanel.setVisible(true);
    }
}
