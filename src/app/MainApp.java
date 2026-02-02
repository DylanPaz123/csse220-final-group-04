package app;

import javax.swing.SwingUtilities;

import ui.GameWindow;
import model.GameModel;
/**
 * Class: MainApp
 * @author Team Underscore (Group 04) 
 * Dylan, Lilly, and Fred
 * <br>Purpose: Top level class for CSSE220 Project containing main method 
 * Entry point for the final project.
 */
public class MainApp {
	private GameModel game = new GameModel();
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
		new MainApp().run();
		});
		}
	
	public void run() {
		GameWindow.show();
		// Hint: MainApp should not contain game logic or drawing code
		}
}