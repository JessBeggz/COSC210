package GUI;

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

import model.ExerciseList;
import model.Workout;
import model.WorkoutList;

public class WorkoutPanel extends JPanel{

    JButton returnButton = new JButton();
    JTextField nameText = new JTextField(1);
    JButton setNameButton = new JButton();
    String name;

    public WorkoutPanel(MainPanel panel) {
        Workout workout = new Workout();
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
        if (exerciseList.size() == 0) {
            add(new JLabel("No Exercise History."));
        } else {
                for (int i = 0; i < exerciseList.getExerciseList().size(); i++) {
                     add(createButton(exerciseList.getExerciseList().get(i).getName(), new Font("Arial", Font.ITALIC, 16)));
                    } 
            }
        }


     public JButton createButton(String string, Font font) {
        JButton button = new JButton(string);
        button.setFont(font);
        return button;
    }
}
