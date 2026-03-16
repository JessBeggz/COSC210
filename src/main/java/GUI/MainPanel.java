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

//This class is represents the main panel of our workout tracker gui.
// It finds any previous data and is the display of all the other panels
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
    RemoveExercisePanel removeExercisePanel;
    ViewExerciseListPanel viewExerciseListPanel;
    File exerciseListData;
    File workoutListData;

    //REQUIRES:
    //MODIFIES: this
    //EFFECTS: loads any previous data and creates all our panels
    public MainPanel(JFrame frame) {
        reloadPanel = new ReloadPanel(frame, this);
        add(reloadPanel);
        setVisible(true);

        exitPanel = new ExitPanel(frame, this);
        buttonPanel = new HomePanel(frame, this);
        editExerciseListPanel = new EditExerciseListPanel(this);
        workoutHistoryPanel = new WorkoutHistoryPanel(this);
        workoutPanel = new WorkoutPanel(this);
        createExercisePanel = new CreateExercisePanel(this);
        cardioExercisePanel = new CardioExercisePanel(this); //* */
        weightedExercisePanel = new WeightedExercisePanel(this); //* */
        removeExercisePanel = new RemoveExercisePanel(this); //* */
        viewExerciseListPanel = new ViewExerciseListPanel(this); //* */

        backgroundImage = new ImageIcon(getClass().getResource("background1.jpg")).getImage();
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
        removeAll();
        repaint();
        revalidate();
        add(buttonPanel);
        buttonPanel.setVisible(true);
    }

    public void showWorkoutList() {
        removeAll();
        repaint();
        revalidate();
        add(workoutHistoryPanel);
        workoutHistoryPanel.setVisible(true);
        workoutHistoryPanel.viewWorkoutList();
    }

    public void showWorkoutName() {
        add(workoutPanel);
        workoutPanel.setVisible(true);
        workoutPanel.createWorkout();
    }

    public ExerciseList getExerciseList() {
        return exerciseList;
    }

    public WorkoutList getWorkoutList() {
        return workoutList;
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

    public void showRemoveExercisePanel() {
        add(removeExercisePanel);
        removeExercisePanel.setVisible(true);
    }

    public void showViewExerciseListPanel() {
        add(viewExerciseListPanel);
        viewExerciseListPanel.setVisible(true);
        viewExerciseListPanel.view(exerciseList);
    }

    public void reloadData(boolean reload) {
        if (reload) {
            exerciseListData = new File("data/exerciseListData.json");
            workoutListData = new File("data/workoutListData.json");

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
        } else {
            exerciseListData = new File("data/exerciseListDefaultData.json");
            workoutListData = new File("data/workoutListDefaultData.json");
            System.out.println("HI");
            try {
                JsonReader workoutListReader = new JsonReader("./data/workoutListDefaultData.json");
                workoutList = workoutListReader.readWorkoutList();

                JsonReader exerciseListReader = new JsonReader("./data/exerciseListDefaultData.json");
                exerciseList = exerciseListReader.readExerciseList();
                // add(new JLabel("Previous data found!"));
            } catch (IOException e) {
                workoutList = new WorkoutList();
                exerciseList = new ExerciseList();
                // add(new JLabel("No previous data found."));
            }
        }
    }
}
