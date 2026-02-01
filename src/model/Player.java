package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.*;
import java.io.*;

public class Player  {
	private static BufferedImage sprite = null;
	private static boolean triedLoad = false;
	private int x,y;
	private int spriteWidth, spriteHeight;
	
	
	
	public Player(int x, int y) {
		this.x = x;
		this.y = y;
		spriteWidth = 30;
		spriteHeight = 30;
		loadSpriteOnce();
	}

	public void draw(Graphics2D g2) {
	g2.setColor(Color.RED);
	if (sprite != null) {
		g2.drawImage(sprite, x, y, spriteWidth, spriteHeight,null);
	} else {
		g2.setColor(Color.RED);
		g2.fillOval(x, y, spriteWidth, spriteHeight);
	}
	
	}
		
	public void move() {
		x += 30;
		y+= 30;
	}
	
	private static void loadSpriteOnce() {
		if (triedLoad) return;
		triedLoad = true;

		try {
		sprite = ImageIO.read(Player.class.getResource("tennis.png"));
		} catch (IOException | IllegalArgumentException ex) {

		sprite = null; 
		}
		}
//	public int[][] getSurroundingTiles(int curX, int curY) {
//	//	return {0,0,0};
//	}

}
