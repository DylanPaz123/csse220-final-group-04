package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ExitTile extends Entity{

	public ExitTile(int x, int y, String imgSource) {
		super(x, y, imgSource);
		
	}

	public void Open() {
		try {
			sprite = ImageIO.read(Player.class.getResource("open door.png"));
			} catch (IOException | IllegalArgumentException ex) {

			sprite = null; 
			}
	}

}
