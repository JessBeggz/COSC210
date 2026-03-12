package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.CardioExercise;
import model.WeightedExercise;
import model.Workout;
import model.WorkoutList;

public class WorkoutHistoryPanel extends JPanel {

    JButton returnButton = new JButton();

    public WorkoutHistoryPanel(MainPanel panel) {
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
        add(returnButton);

        setVisible(true);
    }

    // REQUIRES: workoutList can't be null
    // EFFECTS: prints the contents of workoutlist in the terminal
    public void viewWorkoutList(WorkoutList workoutList) {
        if (workoutList.size() == 0) {
            add(new JLabel("No Workout History."));
        } else {
            for (Workout workout : workoutList.getWorkoutList()) {
                System.out.println(workout.getName() + ": ");
                add(createLabel(workout.getName(), new Font("Arial", Font.BOLD, 32)));
                for (int i = 0; i < workout.getWorkoutExercises().size(); i++) {
                    if (workout.getWorkoutExercises().get(i) instanceof WeightedExercise weightedExercise) {
                        add(createLabel("- Exercise: " + workout.getWorkoutExercises().get(i).getName(), new Font("Arial", Font.BOLD, 24)));
                        add(createLabel("-- Sets: " + weightedExercise.getSets(), new Font("Arial", Font.ITALIC, 16)));
                        add(createLabel("-- Reps: " + weightedExercise.getReps(), new Font("Arial", Font.ITALIC, 16)));
                        add(createLabel("-- Weight: " + weightedExercise.getWeight(), new Font("Arial", Font.ITALIC, 16)));

                        add(Box.createVerticalStrut(8));
                    } else if (workout.getWorkoutExercises().get(i) instanceof CardioExercise cardioExercise) {
                        add(createLabel("- Exercise: " + cardioExercise.getName(), new Font("Arial", Font.BOLD, 24)));
                        add(createLabel("-- Distance: " + cardioExercise.getDistance(), new Font("Arial", Font.ITALIC, 16)));
                        add(createLabel("-- Time: " + cardioExercise.getTime(), new Font("Arial", Font.ITALIC, 16)));

                        add(Box.createVerticalStrut(8));

                    }
                }
                add(Box.createVerticalStrut(12));
            }
        }
    }

    public JLabel createLabel(String string, Font font) {
        JLabel label = new JLabel(string);
        label.setFont(font);
        return label;
    }

}
