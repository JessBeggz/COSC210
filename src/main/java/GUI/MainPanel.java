package GUI;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.ExerciseList;
import model.WorkoutList;
import persistence.JsonReader;

public class MainPanel extends JPanel {

    private HomePanel buttonPanel;
    private ExitPanel exitPanel;

    private WorkoutList workoutList;
    private ExerciseList exerciseList;

    private Image backgroundImage;

    WorkoutHistoryPanel workoutHistoryPanel;
    
    ReloadPanel reloadPanel;
    File exerciseListData;
    File workoutListData;

    public MainPanel(JFrame frame) {
        exerciseListData = new File("data/exerciseListData.json");
        workoutListData = new File("data/workoutListData.json");
        exitPanel = new ExitPanel(frame, this);
        buttonPanel = new HomePanel(frame, this);
        workoutHistoryPanel = new WorkoutHistoryPanel(this);

        backgroundImage = new ImageIcon(getClass().getResource("background1.jpg")).getImage();

        try {
            JsonReader workoutListReader = new JsonReader("./data/workoutListData.json");
            workoutList = workoutListReader.readWorkoutList();

            JsonReader exerciseListReader = new JsonReader("./data/exerciseListData.json");
            exerciseList = exerciseListReader.readExerciseList();
            add(new JLabel("Previous data found!"));
        } catch (IOException e) {
            workoutList = new WorkoutList();
            exerciseList = new ExerciseList();
            add(new JLabel("No previous data found."));

        }
        add(buttonPanel);
        setVisible(true);

        reloadPanel = new ReloadPanel(frame, this);

        if(!exerciseListData.exists() && !workoutListData.exists()) {
            add(buttonPanel);
            setVisible(true);
        } else {
            add(reloadPanel);
            setVisible(true);
        }
    }

     @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }

    public void showExitPanel() {
        add(exitPanel);
        exitPanel.setVisible(true);
    }

    public void showButtonPanel() {
        add(buttonPanel);
        buttonPanel.setVisible(true);
    }

    public void showWorkoutList() {
        add(workoutHistoryPanel);
        workoutHistoryPanel.setVisible(true);
        workoutHistoryPanel.viewWorkoutList(workoutList);
    }
}
