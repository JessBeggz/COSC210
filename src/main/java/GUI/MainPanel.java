package GUI;

import java.awt.Color;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.ExerciseList;
import model.WorkoutList;
import persistence.JsonReader;

public class MainPanel extends JPanel{
    
    HomePanel buttonPanel;
    ExitPanel exitPanel;

     WorkoutList workoutList;
     ExerciseList exerciseList;

    WorkoutHistoryPanel workoutHistoryPanel;
    public MainPanel(JFrame frame) {
        exitPanel = new ExitPanel(frame, this);
        buttonPanel = new HomePanel(frame, this);
        workoutHistoryPanel = new WorkoutHistoryPanel(this);
        

        setBackground(Color.RED);


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

    }

    public void showExitPanel() {
            add(exitPanel);

            exitPanel.setVisible(true);
    }

    public void showButtonPanel() {
        buttonPanel.setVisible(true);
    }

    public void showWorkoutList() {
        add(workoutHistoryPanel);
        workoutHistoryPanel.setVisible(true);
        workoutHistoryPanel.viewWorkoutList(workoutList);
    }
}
