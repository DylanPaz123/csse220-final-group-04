package ui;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class StartPanel extends JPanel {
	private JButton startButton;
	private JLabel title;
	
	public StartPanel() {
		setLayout(new BorderLayout());
		
		title = new JLabel("Game Start");
		startButton = new JButton("Start");
		
		add(title, BorderLayout.CENTER); 
		add(startButton, BorderLayout.SOUTH);
		
	}
	
	
    public JButton getStartButton() { 
    	return startButton; 
    }
}
