package model;

import java.util.ArrayList;

public class GameModel {

	public Level level = new Level();
	public Player player;
	public ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
	public ArrayList<Tile> tileList = new ArrayList<Tile>();
	public ArrayList<Diamond> diamondList = new ArrayList<Diamond>();
	private char[][] levelOne ={{ 'P', '#', '#', '#', '.', '.', '.', '.', '.', '.' },
								{ '.', '#', '#', '#', '.', '.', '.', '.', 'Z', '.' },
								{ '.', '#', '#', '#', '.', '.', '#', '.', '.', '.' },
								{ '.', '.', '.', '.', '.', 'D', '#', '.', '.', '.' },
								{ '.', '.', '.', 'D', '.', '.', '#', '.', '.', '.' },
								{ '.', '.', '.', '.', '.', '.', '#', '#', '#', '#' },
								{ '#', '#', '#', '#', '.', '.', '.', '.', '.', '.' },
								{ '.', '.', '.', '#', '.', '.', '.', '.', '.', '.' },
								{ '.', '.', '.', '#', '.', '.', '.', '.', 'Z', '.' },
								{ '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' }};
	
	public GameModel() {
		player = new Player(0,0,"steve.png");
		level.addLevel(1, levelOne);
		level.initializeLevel(1, player, tileList, enemyList, diamondList);
	}
}
