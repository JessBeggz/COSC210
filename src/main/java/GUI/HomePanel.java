package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//This class represents that home panel that is the home page gui for our user using our workout tracker
public class HomePanel extends JPanel{

    JButton beginWorkout = new JButton();
    JButton viewWorkoutHistory = new JButton();
    JButton editExerciseList = new JButton();
    JButton viewExerciseList = new JButton();
    JButton exit = new JButton();



    public HomePanel(JFrame frame, MainPanel mainPanel) {

        setLayout(new GridLayout(5,1));

        beginWorkout.setForeground(Color.RED);
        beginWorkout.setFont(new Font("Arial", Font.BOLD, 16));
        beginWorkout.setText("Begin Workout");
        beginWorkout.setPreferredSize(new Dimension(250, 100));
        beginWorkout.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                mainPanel.showWorkoutName();
			}
		});
        add(beginWorkout);

        viewWorkoutHistory.setForeground(Color.RED);
        viewWorkoutHistory.setFont(new Font("Arial", Font.BOLD, 16));
        viewWorkoutHistory.setText("View Workout History");
        viewWorkoutHistory.setPreferredSize(new Dimension(250, 100));
        viewWorkoutHistory.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                mainPanel.showWorkoutList();

			}
		});
        add(viewWorkoutHistory);

        editExerciseList.setForeground(Color.RED);
        editExerciseList.setFont(new Font("Arial", Font.BOLD, 16));
        editExerciseList.setText("Edit Exercise List");
        editExerciseList.setPreferredSize(new Dimension(250, 100));
        editExerciseList.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                mainPanel.showEditExerciseListPanel();

			}
		});
        add(editExerciseList);

        viewExerciseList.setForeground(Color.RED);
        viewExerciseList.setFont(new Font("Arial", Font.BOLD, 16));
        viewExerciseList.setText("View Exercise List");
        viewExerciseList.setPreferredSize(new Dimension(250, 100));
        viewExerciseList.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                mainPanel.showViewExerciseListPanel();

			}
		});
        add(viewExerciseList);

        exit.setForeground(Color.RED);
        exit.setFont(new Font("Arial", Font.BOLD, 16));
        exit.setText("Exit");
        exit.setPreferredSize(new Dimension(250, 100));
        exit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                mainPanel.showExitPanel();

			}
		});
        add(exit);

        setVisible(true);
    }


}
