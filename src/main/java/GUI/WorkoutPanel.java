package GUI;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.InputMismatchException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.CardioExercise;
import model.Exercise;
import model.ExerciseList;
import model.WeightedExercise;
import model.Workout;
import model.WorkoutList;
import model.exceptions.DuplicateExerciseException;

//This class represents the workout panel that allows the user to create their workouts
public class WorkoutPanel extends JPanel{

    JButton returnButton = new JButton();
    JTextField nameText = new JTextField(1);
    JButton setNameButton = new JButton();
    String name;
    Workout workout;
    MainPanel mainPanel;
    WorkoutList workoutList;
    ExerciseList exerciseList;

    public WorkoutPanel(MainPanel panel) {
        mainPanel = panel;
        
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

    public void createWorkout() {
        workoutList = mainPanel.getWorkoutList();
        exerciseList = mainPanel.getExerciseList();
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
                chooseExercise();
            }
        });
        add(setNameButton);
    }

    public void chooseExercise() {
        ExerciseList el = new ExerciseList();
        for (Exercise exercise : exerciseList.getExerciseList()) {
            if (exercise instanceof WeightedExercise weightedExercise) {
                try {
                    el.add(new WeightedExercise(exercise.getName(), weightedExercise.getSets(), weightedExercise.getReps(), weightedExercise.getWeight()));
                } catch (DuplicateExerciseException e) {
                }
            } else if (exercise instanceof CardioExercise cardioExercise) {
                try {
                    el.add(new CardioExercise(exercise.getName(), cardioExercise.getDistance(), cardioExercise.getTime()));
                } catch (DuplicateExerciseException e) {
                }
            }
        }
        exerciseList = el;
        removeAll();
        repaint();
        revalidate();
        add(returnButton);
        JButton completeWorkout = new JButton("Complete Workout");
        if (exerciseList.size() == 0) {
            add(new JLabel("No Exercise History."));
        } else {
                for (int i = 0; i < el.getExerciseList().size(); i++) {
                     add(createButton(el.getExerciseList().get(i).getName(), new Font("Arial", Font.ITALIC, 16), i));
                    } 
            }
            
            completeWorkout.setFont(new Font("Arial", Font.ITALIC, 16));
            completeWorkout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               addWorkout(workout);
            }
        });
        add(completeWorkout);
        
        }


     public JButton createButton(String string, Font font, int key) {
        JButton button = new JButton(string);
        button.setFont(font);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               setData(key);
            }
        });
        return button;
    }

    public void setData(int key) {
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
            try {
                int repsInt = Integer.parseInt(reps.getText());
               int setsInt = Integer.parseInt(sets.getText());
               int weightInt = Integer.parseInt(weight.getText());
               weightedExercise.setReps(repsInt);
               weightedExercise.setSets(setsInt);
               weightedExercise.setWeight(weightInt);
               workout.addExercise(weightedExercise);
               chooseExercise();
            } catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(WorkoutPanel.this, "Must enter numbers");
            }
               
            }
        });
            add(button);
        } else if(exercise instanceof CardioExercise cardioExercise) {
            JTextField distance = new JTextField(1);
            JTextField time = new JTextField(1);
            JButton button = new JButton("Add to " + workout.getName());
            add(createLabel("Time in minutes (Ex. '30')", new Font("Arial", Font.BOLD, 16)));
            add(distance);
            add(createLabel("Distance in km (Ex. '5')", new Font("Arial", Font.BOLD, 16)));
            add(time);
            button.setFont(new Font("Arial", Font.ITALIC, 16));
            button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            try {
                int timeInt = Integer.parseInt(time.getText());
               int distanceInt = Integer.parseInt(distance.getText());
               cardioExercise.setTime(timeInt);
               cardioExercise.setDistance(distanceInt);
               workout.addExercise(cardioExercise);
               chooseExercise();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(WorkoutPanel.this, "Must enter numbers");

            }
               
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

    public void addWorkout(Workout workout) {
        removeAll();
        repaint();
        revalidate();
        JButton yesButton = new JButton("Yes");
        JButton noButton = new JButton("No");
        add(createLabel("Would you like to save this workout", new Font("Arial", Font.BOLD, 16)));
        yesButton.setFont(new Font("Arial", Font.ITALIC, 16));
        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               workoutList.addWorkout(workout);
               mainPanel.showButtonPanel();
            }
        });
            add(yesButton);
        noButton.setFont(new Font("Arial", Font.ITALIC, 16));
        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               mainPanel.showButtonPanel();
            }
        });
            add(noButton);
    }
}
