package ui;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class StartPanel extends JPanel {
	private JButton startButton;
	private JLabel title;
	
	public StartPanel() {
		setLayout(new BorderLayout());
		
		startButton = new JButton("Start");
		
		ImageIcon icon = new ImageIcon(getClass().getResource("titlescreen.png"));
        JLabel imageLabel = new JLabel(icon);
		
		add(imageLabel); 
		add(startButton, BorderLayout.SOUTH);
		
	}
	
	
    public JButton getStartButton() { 
    	return startButton; 
    }
}
