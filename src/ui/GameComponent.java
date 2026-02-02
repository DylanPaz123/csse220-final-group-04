package ui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.Timer;

import model.GameModel;
import model.Player;

public class GameComponent extends JComponent {
	private GameModel model;
	private Timer timer;

	public GameComponent(GameModel model) {
	this.model = model;
	timer = new Timer(10, e -> {
    	repaint();
    });
	timer.start();
    
	
	setFocusable(true);
	addKeyListener(new KeyAdapter() {
  	  @Override
  	  public void keyPressed(KeyEvent e) {
  		if (e.getKeyCode() == KeyEvent.VK_UP) {
    	      model.player.moveUp();
          }
  		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
  	      model.player.moveDown();
        }
  		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
  	      model.player.moveLeft();
        }
  		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
  	      model.player.moveRight();
        }
  		repaint();
  	  }
	});
	
	}


	@Override
	protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	Graphics2D g2 = (Graphics2D) g;
	
	for(int i=0; i<model.tileList.size(); i++) {
		model.tileList.get(i).draw(g2);
	}
	
	for(int i=0; i<model.enemyList.size(); i++) {
		model.enemyList.get(i).draw(g2);
	}

	model.player.draw(g2);
	
	
	}
}
