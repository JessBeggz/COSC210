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

import model.ExerciseList;

//This class represents the ability to edit the exercise list
public class EditExerciseListPanel extends JPanel {
    JButton createExercise = new JButton();
    JButton removeExercise = new JButton();
    JButton returnButton = new JButton();
    ExerciseList list;
    JLabel text = new JLabel("Do you wish to create an exercise or remove an exercise?", JLabel.CENTER);

    public EditExerciseListPanel(MainPanel mainPanel) {
        list = new ExerciseList();

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
                mainPanel.showButtonPanel();
            }
        });
        add(returnButton);
        
        
        text.setFont(new Font("Arial", Font.ITALIC, 18));
        add(text);

        createExercise.setForeground(Color.RED);
        createExercise.setFont(new Font("Arial", Font.BOLD, 16));
        createExercise.setText("Create Exercise");
        createExercise.setPreferredSize(new Dimension(250, 100));
        createExercise.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                mainPanel.showCreateExercisePanel();
			}
		});
        add(createExercise);

        removeExercise.setForeground(Color.RED);
        removeExercise.setFont(new Font("Arial", Font.BOLD, 16));
        removeExercise.setText("Remove Exercise");
        removeExercise.setPreferredSize(new Dimension(250, 100));
        removeExercise.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                mainPanel.showRemoveExercisePanel();
			}
		});
        add(removeExercise);
    }
}
