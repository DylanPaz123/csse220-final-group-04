package model;

import java.util.ArrayList;

public class GameModel {

	private Level level = new Level();
	public Player player;
	public ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
	public ArrayList<Tile> tileList = new ArrayList<Tile>();
	
	private char[][] levelOne ={{ 'P', '#', '#', '#', '.', '.', '.', '.', '.', '.' },
								{ '.', '#', '#', '#', '.', '.', '.', '.', 'Z', '.' },
								{ '.', '#', '#', '#', '.', '.', '#', '.', '.', '.' },
								{ '.', '.', '.', '.', '.', '.', '#', '.', '.', '.' },
								{ '.', '.', '.', '.', '.', '.', '#', '.', '.', '.' },
								{ '.', '.', '.', '.', '.', '.', '#', '#', '#', '#' },
								{ '#', '#', '#', '#', '.', '.', '.', '.', '.', '.' },
								{ '.', '.', '.', '#', '.', '.', '.', '.', '.', '.' },
								{ '.', '.', '.', '#', '.', '.', '.', '.', 'Z', '.' },
								{ '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' }};
	
	public GameModel() {
		player = new Player(0,0,"steve.png");
		level.addLevel(1, levelOne);
		level.initializeLevel(1, player, tileList, enemyList);
	}
}
