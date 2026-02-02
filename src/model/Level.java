package model;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
public class Level {
	
	private Player player;
	private Enemy enemy;
	private char[][] levelMap;
	private int levelId;
	
	HashMap<Integer, char[][]> levels = new HashMap<>();
	
	public Level() {
		
	}
	
	public void initializeLevel(int levelId, Player player, ArrayList<Tile> tileList, ArrayList<Enemy> enemyList) {
			this.levelMap = levels.get(levelId);
		
		for (int y = 0; y < levelMap.length ; y++) {
			for (int x = 0; x < levelMap[y].length ; x++) {
				if (levelMap[y][x] == ('.')) {
					Tile newGround = new Tile(x,y,"darkwall.png");
					tileList.add(newGround);
				} else if (levelMap[y][x] == ('#')) {
					Tile newWall = new Tile(x,y,"lightwall.png");
					tileList.add(newWall);
				} else if (levelMap[y][x]==('G')) {
					
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
					// initialize exit
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
