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

public class HomeFrame extends JFrame {

    JButton beginWorkout = new JButton();
    JButton viewWorkoutHistory = new JButton();
    JButton exit = new JButton();

    JPanel mainPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    ExitPanel exitPanel = new ExitPanel(this, buttonPanel);


    public HomeFrame() {
        super("Workout App");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setUndecorated(true);
        setSize(1280, 720);
        setBackground(Color.GRAY);

        mainPanel.setBackground(Color.BLACK);

        buttonPanel.setLayout(new GridLayout(5,1));

        beginWorkout.setForeground(Color.RED);
        beginWorkout.setFont(new Font("Arial", Font.BOLD, 16));
        beginWorkout.setText("Begin Workout");
        beginWorkout.setPreferredSize(new Dimension(250, 100));
        beginWorkout.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ae) {
                
			}
		});
        buttonPanel.add(beginWorkout);

        viewWorkoutHistory.setForeground(Color.RED);
        viewWorkoutHistory.setFont(new Font("Arial", Font.BOLD, 16));
        viewWorkoutHistory.setText("View Workout History");
        viewWorkoutHistory.setPreferredSize(new Dimension(250, 100));
        buttonPanel.add(viewWorkoutHistory);
        mainPanel.add(buttonPanel);

        exit.setForeground(Color.RED);
        exit.setFont(new Font("Arial", Font.BOLD, 16));
        exit.setText("Exit");
        exit.setPreferredSize(new Dimension(250, 100));
        exit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ae) {
                buttonPanel.setVisible(false);
                exitPanel.setVisible(true);
                mainPanel.add(exitPanel);
			}
		});
        buttonPanel.add(exit);

        this.add(mainPanel);

        
    }

     public void setMainVisible() {
        buttonPanel.setVisible(true);
    }

}
