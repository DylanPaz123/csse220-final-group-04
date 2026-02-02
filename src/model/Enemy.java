package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.*;

public class Enemy  {
	private static BufferedImage sprite = null;
	private static boolean triedLoad = false;
	public int x,y;
	Level levelMap;
	
	public Enemy(int x, int y, String imgSource) {
		this.x = x;
		this.y = y;
		loadSpriteOnce(imgSource);
	}

	public void draw(Graphics2D g2) {
		if (sprite != null) {
		// sprite replaces the circle
		g2.drawImage(sprite, x*50, y*50, 50, 50, null);
		} else {
		// fallback if sprite failed to load
		g2.setColor(Color.BLACK);
		g2.fillOval(x*50, y*50, 50, 50);
		}
	}
	
	private static void loadSpriteOnce(String imgSource) {
		if (triedLoad) return;
		triedLoad = true;
		try {
		sprite = ImageIO.read(Player.class.getResource(imgSource));
		} catch (IOException | IllegalArgumentException ex) {
		sprite = null; 
		}
	}

}
