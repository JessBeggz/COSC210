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
import model.exceptions.DefaultExerciseRemovalException;
import model.exceptions.ExerciseNotFoundException;

//This class represents the remove exercise panel where the user can remove an exercise from the list
public class RemoveExercisePanel extends JPanel {
    JLabel text = new JLabel("Enter the name of the exercise that you wish to remove:", JLabel.CENTER);
    JTextField textBox = new JTextField(10);
    JButton submit = new JButton();

    public RemoveExercisePanel(MainPanel mainPanel, ExerciseList list) {
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
                try {
                    list.removeExercise(exerciseName);
                    JOptionPane.showMessageDialog(RemoveExercisePanel.this, "Exercise was successfully removed!");
                    setVisible(false);
                    mainPanel.showButtonPanel();
                } catch (DefaultExerciseRemovalException ex) {
                    JOptionPane.showMessageDialog(RemoveExercisePanel.this, "This exercise cannot be removed as it is a default exercise!");
                    setVisible(false);
                    mainPanel.showButtonPanel();
                } catch (ExerciseNotFoundException ex) {
                    JOptionPane.showMessageDialog(RemoveExercisePanel.this, "No exercise was found with that name!");
                    setVisible(false);
                    mainPanel.showButtonPanel();
                }
            }
        });
        add(submit);
    }

}
