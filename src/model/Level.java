package model;

import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
public class Level {
	
	private Player player;
	private Enemy enemy;
	private char[][] levelMap;
	private int levelId;
	private Diamond diamond;
	private ExitTile exit;
	HashMap<Integer, char[][]> levels = new HashMap<>();
	
	public Level() {
		
	}
	
	public void initializeLevel(int levelId, Player player, ArrayList<Tile> tileList, ArrayList<Enemy> enemyList, ArrayList<Diamond> diamondList, ArrayList<ExitTile> exits) {
			this.levelMap = levels.get(levelId);
		
		for (int y = 0; y < levelMap.length ; y++) {
			for (int x = 0; x < levelMap[y].length ; x++) {
				if (levelMap[y][x] == ('.')) {
					Tile newGround = new Tile(x,y,"darkwall.png");
					tileList.add(newGround);
				} else if (levelMap[y][x] == ('#')) {
					Tile newWall = new Tile(x,y,"lightwall.png");
					tileList.add(newWall);
				} else if (levelMap[y][x]==('D')) {
					// Initialize Gem
					Tile newGround = new Tile(x,y,"darkwall.png");
					tileList.add(newGround);
					Diamond newDiamond = new Diamond(x,y,"diamond.png");
					diamondList.add(newDiamond);
				} else if (levelMap[y][x]==('P')) {
					// initialize player
					Tile newTile = new Tile(x,y,"darkwall.png");
					tileList.add(newTile);
					player.x = x;
					player.y = y;
					player.levelMap = this;
					
				} else if (levelMap[y][x]==('Z')) {
					Tile newTile = new Tile(x,y,"darkwall.png");
					tileList.add(newTile);
					Enemy newEnemy = new Enemy(x,y,"zombiemc.png");
					enemyList.add(newEnemy);
					newEnemy.levelMap = this;
				} else if (levelMap[y][x]==('E')) {
					// Initialize Gem
					Tile newGround = new Tile(x,y,"darkwall.png");
					tileList.add(newGround);
					ExitTile newExit = new ExitTile(x,y,"closed door.png");
					
					exits.add(newExit);
				}
			}
			
		}
	}
	
	public void addLevel(int levelId, char[][] levelLayout) {
		levels.put(levelId, levelLayout);
	}
	
	 public Player getPlayer() { return player; }

	 public char[][] getMap() {
		return levelMap;
	 }
	 
	 
	
}
