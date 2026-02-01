package ui;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

import model.GameModel;

public class GameComponent extends JComponent {

	
	
	private GameModel model;


	public GameComponent(GameModel model) {
	this.model = model;
	}


	@Override
	protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	Graphics2D g2 = (Graphics2D) g;

	// Minimal placeholder to test  it’s running
	


	// TODO: draw based on model state
	}
}
