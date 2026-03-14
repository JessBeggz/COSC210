package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.ExerciseList;
import model.WorkoutList;

public class ReloadPanel extends JPanel {
    JButton yes = new JButton();
    JButton no = new JButton();
    JLabel text = new JLabel("Do you wish to reload previous data?", JLabel.CENTER);
    File exerciseListData = new File("data/exerciseListData.json");
    File workoutListData = new File("data/workoutListData.json");

    public ReloadPanel(JFrame frame, MainPanel mainPanel) {
        setLayout(new GridLayout(5,1));
        setBackground(Color.GRAY);
        
        text.setFont(new Font("Arial", Font.ITALIC, 18));
        add(text);
        
        yes.setForeground(Color.RED);
        yes.setFont(new Font("Arial", Font.BOLD, 16));
        yes.setText("Yes");
        yes.setPreferredSize(new Dimension(250, 100));
        yes.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                mainPanel.showButtonPanel();
			}
		});
        add(yes);

        no.setForeground(Color.RED);
        no.setFont(new Font("Arial", Font.BOLD, 16));
        no.setText("No");
        no.setPreferredSize(new Dimension(250, 100));
        no.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ae) {
                exerciseListData.delete();
                workoutListData.delete();

            WorkoutList workoutList = new WorkoutList();
            ExerciseList exerciseList = new ExerciseList();

            setVisible(false);
                mainPanel.showButtonPanel();
			}
		});
        add(no);
    }

}

