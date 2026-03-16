package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import persistence.JsonWriter;


// This class represents the exit panel that gives the user option to save and exit,
// exit without saving, or cancel and return to home panel.
public class ExitPanel extends JPanel {

    JButton saveAndExit = new JButton();
    JButton exit = new JButton();
    JButton cancel = new JButton();


    //MODIFIES: this
    //EFFECTS: shows 3 buttons giveing user option to save and exit, exit without saving, or to cancel
    // and return to the home page
    public ExitPanel(JFrame frame, MainPanel mainPanel) {

        setLayout(new GridLayout(5, 1));

        saveAndExit.setForeground(Color.RED);
        saveAndExit.setFont(new Font("Arial", Font.BOLD, 16));
        saveAndExit.setText("Save & Exit");
        saveAndExit.setPreferredSize(new Dimension(250, 100));
        saveAndExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    JsonWriter exerciseWriter = new JsonWriter("./data/exerciseListData.json");
                    JsonWriter workoutWriter = new JsonWriter("./data/workoutListData.json");
                    exerciseWriter.open();
                    exerciseWriter.write(mainPanel.getExerciseList());
                    exerciseWriter.closeWriter();
                    workoutWriter.open();
                    workoutWriter.write(mainPanel.getWorkoutList());
                    workoutWriter.closeWriter();
                    frame.dispose();
                } catch (IOException ex) {
                    add(new JLabel("Failed to save data... "));
                }
            }
        });
        add(saveAndExit);

        exit.setForeground(Color.RED);
        exit.setFont(new Font("Arial", Font.BOLD, 16));
        exit.setText("Exit");
        exit.setPreferredSize(new Dimension(250, 100));
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
            }
        });
        add(exit);

        cancel.setForeground(Color.RED);
        cancel.setFont(new Font("Arial", Font.BOLD, 16));
        cancel.setText("Cancel");
        cancel.setPreferredSize(new Dimension(250, 100));
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                mainPanel.showButtonPanel();
            }
        });
        add(cancel);

        setVisible(true);

    }
}
