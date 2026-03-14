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

import model.CardioExercise;
import model.ExerciseList;
import model.exceptions.DuplicateExerciseException;

public class CardioExercisePanel extends JPanel {
    JLabel text = new JLabel("Enter exercise name:", JLabel.CENTER);
    JTextField textBox = new JTextField(10);
    JButton submit = new JButton();

    public CardioExercisePanel(MainPanel mainPanel, ExerciseList list) {
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
                CardioExercise c = new CardioExercise(exerciseName,0,0);
                try {
                    list.add(c);
                    JOptionPane.showMessageDialog(CardioExercisePanel.this, "Exercise was successfully added!");
                    setVisible(false);
                    mainPanel.showButtonPanel();
                } catch (DuplicateExerciseException ex) {
                    JOptionPane.showMessageDialog(CardioExercisePanel.this, "Exercise already exits, cannot add duplicates");
                    setVisible(false);
                    mainPanel.showButtonPanel();
                }
            }
        });
        add(submit);
    }

}
