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

public class ViewExerciseListPanel extends JPanel {
    JButton returnButton = new JButton();
    
    public ViewExerciseListPanel(MainPanel mainPanel, ExerciseList list) {
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
                mainPanel.showButtonPanel();
            }
        });
    }

    public void view(ExerciseList exerciseList) {
        removeAll();
        add(returnButton);

        for (int i = 0; i < exerciseList.size(); i++) {
            add(createLabel(exerciseList.getExerciseList().get(i).getName(), new Font("Arial", Font.ITALIC, 24)));
        }
    }

    public JLabel createLabel(String string, Font font) {
        JLabel label = new JLabel(string);
        label.setFont(font);
        return label;
    }
}
