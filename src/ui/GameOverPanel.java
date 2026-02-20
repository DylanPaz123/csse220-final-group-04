package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameOverPanel extends JPanel {
	private JButton restartButton;
	private JButton exitButton;
	private JPanel buttonRow;
	
	public GameOverPanel() {
		buttonRow = new JPanel();
		buttonRow.setLayout(new FlowLayout(FlowLayout.CENTER));
		setLayout(new BorderLayout());
		
		restartButton = new JButton("Restart");
		exitButton = new JButton("Exit");
		
		ImageIcon icon = new ImageIcon(getClass().getResource("gameover.png"));
        JLabel imageLabel = new JLabel(icon);
        
		add(imageLabel);
		
		buttonRow.add(restartButton);
		buttonRow.add(exitButton);
		
		add(buttonRow,BorderLayout.SOUTH);
	}
	
	public JButton getRestartButton() { 
    	return restartButton; 
    }
	
	public JButton getExitButton() { 
    	return exitButton; 
    }
}
