package model;

import java.awt.Color;
import java.util.Random;
import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.*;
import javax.swing.Timer;

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
	
	public void moveDown() {
		if(y<9 && y>=0 && levelMap.getMap()[y+1][x] != '#') {
			y+=1;
		}
	}

	public void moveUp() {
		if(y<=9 && y>0 && levelMap.getMap()[y-1][x] != '#') {
			y-=1;
		}
	}
	
	public void move() {
		Random rng = new Random();
		if(rng.nextInt(0,75) == 0) {
			int direction = rng.nextInt(0,3);
			if(direction == 0){
				moveUp();
			}
			else if(direction == 1){
				moveDown();
			}
			else if(direction == 2){
				moveRight();
			}
			else if(direction == 3){
				moveLeft();
			}
		}
		
	}
	
	public void moveRight() {
		if(x<9 && x>=0 && levelMap.getMap()[y][x+1] != '#') {
			x+=1;
		}
	}

	public void moveLeft() {
		if(x<=9 && x>0 && levelMap.getMap()[y][x-1] != '#') {
			x-=1;
		}
	}

}
