package GUI;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
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
    WorkoutPanel workoutPanel;
    ReloadPanel reloadPanel;
    EditExerciseListPanel editExerciseListPanel;
    CreateExercisePanel createExercisePanel;
    CardioExercisePanel cardioExercisePanel;
    WeightedExercisePanel weightedExercisePanel;
    File exerciseListData;
    File workoutListData;

    public MainPanel(JFrame frame) {
        exerciseListData = new File("data/exerciseListData.json");
        workoutListData = new File("data/workoutListData.json");

        exerciseList = new ExerciseList();

        exitPanel = new ExitPanel(frame, this);
        buttonPanel = new HomePanel(frame, this);
        editExerciseListPanel = new EditExerciseListPanel(this);
        workoutHistoryPanel = new WorkoutHistoryPanel(this);
        workoutPanel = new WorkoutPanel(this);
        createExercisePanel = new CreateExercisePanel(this);
        cardioExercisePanel = new CardioExercisePanel(this, exerciseList);
        weightedExercisePanel = new WeightedExercisePanel(this, exerciseList);

        backgroundImage = new ImageIcon(getClass().getResource("background1.jpg")).getImage();

        try {
            JsonReader workoutListReader = new JsonReader("./data/workoutListData.json");
            workoutList = workoutListReader.readWorkoutList();

            JsonReader exerciseListReader = new JsonReader("./data/exerciseListData.json");
            exerciseList = exerciseListReader.readExerciseList();
            // add(new JLabel("Previous data found!"));
        } catch (IOException e) {
            workoutList = new WorkoutList();
            exerciseList = new ExerciseList();
            // add(new JLabel("No previous data found."));
        }

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

    public void showWorkoutName() {
        add(workoutPanel);
        workoutPanel.setVisible(true);
        workoutPanel.createWorkout(workoutList, exerciseList);
    }

    public void showEditExerciseListPanel() {
        add(editExerciseListPanel);
        editExerciseListPanel.setVisible(true);
    }

    public void showCreateExercisePanel() {
        add(createExercisePanel);
        createExercisePanel.setVisible(true);
    }

    public void showCardioExercisePanel() {
        add(cardioExercisePanel);
        cardioExercisePanel.setVisible(true);
    }

    public void showWeightedExercisePanel() {
        add(weightedExercisePanel);
        weightedExercisePanel.setVisible(true);
    }
}
