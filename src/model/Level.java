package model;

import java.util.HashMap;
import java.util.Arrays;
public class Level {
	
	private Player player;
	private Enemy enemy;
	private char[][] levelMap;
	private int levelId;
	
	HashMap<Integer, char[][]> levels = new HashMap<>();
	
	
	
	public Level() {
		
	}
	
	public void initializeLevel(int levelId) {
			this.levelMap = levels.get(levelId);
		
		for (int x = 0; x < levelMap.length ; x++) {
			for (int y = 0; y < levelMap[x].length ; y++) {
				if (levelMap[x][y]==('.')) {
					// initialize ground tile
				} else if (levelMap[x][y]==('#')) {
					// initialize wall
				} else if (levelMap[x][y]==('G')) {
				
				
				} else if (levelMap[x][y]==('P')) {
					// initialize player
					player = new Player(x,y);
					
				} else if (levelMap[x][y]==('Z')) {
					//initialize zombie
					enemy = new Enemy(x,y);
				} else if (levelMap[x][y]==('E')) {
					// initialize exit
				}
			}
			
		}
	}
	
	public void addLevel(int levelId, char[][] levelLayout) {
		levels.put(levelId, levelLayout);
	}
	
	 public Player getPlayer() { return player; }

}
