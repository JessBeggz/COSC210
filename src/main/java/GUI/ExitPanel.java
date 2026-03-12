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

public class ExitPanel extends JPanel{
    
    JButton saveAndExit = new JButton();
    JButton exit = new JButton();
    JButton cancel = new JButton();

    public ExitPanel(JFrame frame, MainPanel mainPanel) {

        setLayout(new GridLayout(5,1));

        exit.setForeground(Color.RED);
        exit.setFont(new Font("Arial", Font.BOLD, 16));
        exit.setText("Exit");
        exit.setPreferredSize(new Dimension(250, 100));
        exit.addActionListener(new ActionListener(){
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
        cancel.addActionListener(new ActionListener(){
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
