package GUI;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Exercise;
import model.ExerciseList;
import model.WeightedExercise;
import model.Workout;
import model.WorkoutList;

public class WorkoutPanel extends JPanel{

    JButton returnButton = new JButton();
    JTextField nameText = new JTextField(1);
    JButton setNameButton = new JButton();
    String name;
    Workout workout;
    MainPanel thePanel;

    public WorkoutPanel(MainPanel panel) {
        thePanel = panel;
        setPreferredSize(new Dimension(500, 500));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.GRAY);

        returnButton.setForeground(Color.RED);
        returnButton.setFont(new Font("Arial", Font.BOLD, 16));
        returnButton.setText("Return");
        returnButton.setPreferredSize(new Dimension(250, 100));
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                panel.showButtonPanel();
            }
        });

        setVisible(true);
    }

    public void createWorkout(WorkoutList workoutList, ExerciseList exerciseList) {
        removeAll();
        repaint();
        revalidate();
        add(nameText);
        add(returnButton);
        setNameButton.setForeground(Color.RED);
        setNameButton.setFont(new Font("Arial", Font.BOLD, 16));
        setNameButton.setText("Create");
        setNameButton.setPreferredSize(new Dimension(250, 100));
        setNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                name = nameText.getText();
                workout = new Workout(name);
                remove(setNameButton);
                remove(nameText);
                chooseExercise(workoutList, exerciseList);
            }
        });
        add(setNameButton);
    }

    public void chooseExercise(WorkoutList workoutList, ExerciseList exerciseList) {
        removeAll();
        repaint();
        revalidate();
        add(returnButton);
        JButton completeWorkout = new JButton("Complete Workout");
        if (exerciseList.size() == 0) {
            add(new JLabel("No Exercise History."));
        } else {
                for (int i = 0; i < exerciseList.getExerciseList().size(); i++) {
                     add(createButton(exerciseList.getExerciseList().get(i).getName(), new Font("Arial", Font.ITALIC, 16), i, workoutList, exerciseList));
                    } 
            }

            completeWorkout.setFont(new Font("Arial", Font.ITALIC, 16));
            completeWorkout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               workoutList.addWorkout(workout);
               thePanel.showButtonPanel();
            }
        });
        add(completeWorkout);
        
        }


     public JButton createButton(String string, Font font, int key, WorkoutList workoutList, ExerciseList exerciseList) {
        JButton button = new JButton(string);
        button.setFont(font);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               setData(key, workoutList, exerciseList);
            }
        });
        return button;
    }

    public void setData(int key, WorkoutList workoutList, ExerciseList exerciseList) {
        removeAll();
        repaint();
        revalidate();
        add(returnButton);
        Exercise exercise = exerciseList.getExerciseList().get(key);
        add(createLabel(exercise.getName(), new Font("Arial", Font.BOLD, 24)));
        if(exercise instanceof WeightedExercise weightedExercise) {
            JTextField reps = new JTextField(1);
            JTextField sets = new JTextField(1);
            JTextField weight = new JTextField(1);
            JButton button = new JButton("Add to " + workout.getName());
            add(createLabel("Sets (Ex. '3')", new Font("Arial", Font.BOLD, 16)));
            add(reps);
            add(createLabel("Reps (Ex. '12')", new Font("Arial", Font.BOLD, 16)));
            add(sets);
            add(createLabel("Weight in pounds (Ex. '100')", new Font("Arial", Font.BOLD, 16)));
            add(weight);
            button.setFont(new Font("Arial", Font.ITALIC, 16));
            button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               int repsInt = Integer.parseInt(reps.getText());
               int setsInt = Integer.parseInt(sets.getText());
               int weightInt = Integer.parseInt(weight.getText());
               weightedExercise.setReps(repsInt);
               weightedExercise.setSets(setsInt);
               weightedExercise.setWeight(weightInt);
               workout.addExercise(weightedExercise);
               chooseExercise(workoutList, exerciseList);
            }
        });
            add(button);
        }
    }

    public JLabel createLabel(String string, Font font) {
        JLabel label = new JLabel(string);
        label.setFont(font);
        return label;
    }
}
