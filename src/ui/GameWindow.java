package ui;

import java.awt.Frame;

import javax.swing.JFrame;

import model.GameModel;

public class GameWindow {
	public static final int WIDTH = 600; 
	public static final int HEIGHT = 600;
	

	public static void show() {
		
		// Minimal model instance (empty for now, by design)
		GameModel model = new GameModel();


		JFrame frame = new JFrame("CSSE220 Final Project");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		frame.add(new GameComponent(model));


		frame.setSize(WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null); // center on screen (nice UX, still minimal)
		frame.setVisible(true);
		}

}
