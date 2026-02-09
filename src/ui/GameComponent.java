package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JComponent;
import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.swing.*; 
import model.GameModel;
import model.Player;
import java.awt.image.BufferedImage;

@SuppressWarnings("serial")
public class GameComponent extends JComponent {
	
	private GameModel model;
	private Timer timer;
	private JTextField lives;
	private boolean gameOverToggle = false;
	private BufferedImage gameOverSprite;
	
	public GameComponent(GameModel model) {
	this.model = model;
	this.lives = new JTextField("Lives: 3");
	
	timer = new Timer(30, e -> {
		
		for(int i=0; i<model.enemyList.size(); i++) {
			this.model.enemyList.get(i).move();
			if (this.model.enemyList.get(i).x == this.model.player.x && this.model.enemyList.get(i).y == this.model.player.y) {
				model.player.lives -=1;
				model.enemyList.get(i).moveAway();
				if (model.player.lives == 0) {
					gameOverToggle = true;
				}
			}
		}
		
    	repaint();
    });
	
	
	timer.start();
    
	String gameOverImgSource = "gameover.png";
	try {
		gameOverSprite = ImageIO.read(GameComponent.class.getResource(gameOverImgSource));
	} catch (IOException | IllegalArgumentException ex) {
		gameOverSprite = null; 
	}
	
	setFocusable(true);
	addKeyListener(new KeyAdapter() {
  	  @Override
  	  public void keyPressed(KeyEvent e) {
  		if (e.getKeyCode() == KeyEvent.VK_UP) {
  			
  				model.player.moveUp();
  			
          }
  		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
  			boolean collectedDiamond = false;
  				for(int i=0; i<model.diamondList.size(); i++) {
  					
  					if (model.diamondList.get(i).x ==model.player.x && model.diamondList.get(i).y == model.player.y) {
  						
  						model.diamondList.remove(i);
  						model.player.score += 1;
  						collectedDiamond = true;
  					}
  				}
  			if (collectedDiamond == false) {
  				model.player.moveDown();
  			}
  	      
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
	
	if(!gameOverToggle) {
		for(int i=0; i<model.tileList.size(); i++) {
			model.tileList.get(i).draw(g2);
		}
		
		for(int i=0; i<model.enemyList.size(); i++) {
			model.enemyList.get(i).draw(g2);
		}

		for(int i=0; i<model.diamondList.size(); i++) {
			model.diamondList.get(i).draw(g2);
		}
		model.player.draw(g2);
		Font font = new Font("Serif", Font.PLAIN, 36);
		
		g.setFont(font);
		g.drawString("Lives: " + model.player.lives,10 , 30);
		g.drawString("Score: " + model.player.score,10, 60);
	} else {
		if (gameOverSprite != null) {
			// sprite replaces the rect
			g2.drawImage(gameOverSprite, 0, 0, 515, 535, null);
			} else {
			// fallback if sprite failed to load
			g2.setColor(Color.RED);
			g2.fillRect(0, 0, 515, 535);
		}
		
	}
	}
	
	
}
