package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Entity {
	private BufferedImage sprite = null;
	private boolean triedLoad = false;
	public int x,y;
	Level levelMap;
	
	public Entity(int x, int y, String imgSource) {
		this.x = x;
		this.y = y;
		loadSpriteOnce(imgSource);
	}
	
	public void draw(Graphics2D g2) {
		if (sprite != null) {
		// sprite replaces the circle
		g2.drawImage(sprite, (x)*50, (y)*50, 50, 50, null);
		} else {
		// fallback if sprite failed to load
		g2.setColor(Color.RED);
		g2.fillOval((x)*50, (y)*50, 50, 50);
		}
	}
	
	private void loadSpriteOnce(String imgSource) {
		if (triedLoad) return;
		triedLoad = true;

		try {
		sprite = ImageIO.read(Player.class.getResource(imgSource));
		} catch (IOException | IllegalArgumentException ex) {

		sprite = null; 
		}
	}
	
}
