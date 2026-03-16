package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.ExerciseList;
import model.WeightedExercise;
import model.exceptions.DuplicateExerciseException;

//This class represents the weighted exercise panel where the user can create a weighted exercise and add it to the list
public class WeightedExercisePanel extends JPanel {
    JLabel text = new JLabel("Enter exercise name:", JLabel.CENTER);
    JTextField textBox = new JTextField(10);
    JButton submit = new JButton();

    public WeightedExercisePanel(MainPanel mainPanel, ExerciseList list) {
        text.setFont(new Font("Arial", Font.ITALIC, 18));
        add(text);

        add(textBox);

        submit.setForeground(Color.RED);
        submit.setFont(new Font("Arial", Font.BOLD, 16));
        submit.setText("Submit");
        submit.setPreferredSize(new Dimension(250, 100));
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                String exerciseName = textBox.getText();
                WeightedExercise w = new WeightedExercise(exerciseName);
                try {
                    list.add(w);
                    JOptionPane.showMessageDialog(WeightedExercisePanel.this, "Exercise was successfully added!");
                    setVisible(false);
                    mainPanel.showButtonPanel();
                } catch (DuplicateExerciseException ex) {
                    JOptionPane.showMessageDialog(WeightedExercisePanel.this, "Exercise already exits, cannot add duplicates");
                    setVisible(false);
                    mainPanel.showButtonPanel();
                }
            }
        });
        add(submit);
    }

}
