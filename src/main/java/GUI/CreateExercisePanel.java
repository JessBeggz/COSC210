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

public class CreateExercisePanel extends JPanel {
    JButton cardio = new JButton();
    JButton weighted = new JButton();
    JLabel text = new JLabel("Is this exercise a cardio or weighted exercise?", JLabel.CENTER);

    public CreateExercisePanel(MainPanel mainPanel) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.GRAY);

        text.setFont(new Font("Arial", Font.ITALIC, 18));
        add(text);

        cardio.setForeground(Color.RED);
        cardio.setFont(new Font("Arial", Font.BOLD, 16));
        cardio.setText("Cardio Exercise");
        cardio.setPreferredSize(new Dimension(250, 100));
        cardio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                mainPanel.showCardioExercisePanel();
            }
        });
        add(cardio);

        weighted.setForeground(Color.RED);
        weighted.setFont(new Font("Arial", Font.BOLD, 16));
        weighted.setText("Weighted Exercise");
        weighted.setPreferredSize(new Dimension(250, 100));
        weighted.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                mainPanel.showWeightedExercisePanel();
            }
        });
        add(weighted);
        

    }
}
