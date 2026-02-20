package model;

import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
public class Level {
	
	private Player player;
	private char[][] levelMap;
	private int levelId;
	private ExitTile exit;
	HashMap<Integer, char[][]> levels = new HashMap<>();
	
	public Level() {
		
	}
	
	public void initializeLevel(int levelId, Player player, ArrayList<Tile> tileList, ArrayList<Enemy> enemyList, ArrayList<Collectible> diamondList, ArrayList<Collectible> emeraldList, ArrayList<ExitTile> exits) {
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
					Collectible newDiamond = new Collectible(x,y,"diamond.png",1);
					diamondList.add(newDiamond);
				} else if (levelMap[y][x]==('e')) {
					// Initialize Gem
					Tile newGround = new Tile(x,y,"darkwall.png");
					tileList.add(newGround);
					Collectible newEmerald = new Collectible(x,y,"emerald.png",2);
					emeraldList.add(newEmerald);
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
				} else if (levelMap[y][x]==('C')) {
					Tile newTile = new Tile(x,y,"darkwall.png");
					tileList.add(newTile);
					Enemy newEnemy = new Enemy(x,y,"creeper.png", 9);
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
