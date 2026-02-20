package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



public class GameModel {

	public Level level = new Level();
	public Player player;
	public ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
	public ArrayList<Tile> tileList = new ArrayList<Tile>();
	public ArrayList<Diamond> diamondList = new ArrayList<Diamond>();
	public ArrayList<ExitTile> exits = new ArrayList<ExitTile>();
	private char[][] levelOne ={{ 'P', '#', '#', '#', '.', '.', '.', '.', '.', '.' },
								{ '.', '#', '#', '#', '.', '.', '.', '.', 'Z', '.' },
								{ '.', '#', '#', '#', '.', '.', '#', '.', '.', '.' },
								{ '.', '.', '.', '.', '.', 'D', '#', '.', '.', '.' },
								{ '.', '.', '.', 'D', '.', '.', '#', '.', '.', '.' },
								{ '.', '.', '.', '.', '.', '.', '#', '#', '#', '#' },
								{ '#', '#', '#', '#', '.', '.', '.', '.', '.', '.' },
								{ '.', '.', '.', '#', '.', '.', '.', '.', '.', '.' },
								{ '.', 'E', '.', '#', '.', 'D', '.', '.', 'Z', '.' },
								{ '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' }};
	
	
	private char[][] levelTwo ={{ '.', '#', '#', '#', '.', '.', '.', '.', '.', '.' },
								{ 'E', '#', '.', '#', '.', '.', '.', '.', 'Z', '.' },
								{ '.', '#', '.', '#', '.', '.', '#', '.', '.', '.' },
								{ '.', '#', 'Z', '.', '.', 'D', '#', 'D', '.', '.' },
								{ '.', '#', '.', '#', '#', '.', '#', '.', '.', '.' },
								{ '.', '.', '.', '.', '.', '.', '#', '#', '#', '#' },
								{ '#', '#', '#', '#', '.', '.', '.', '.', '.', '.' },
								{ '.', '.', '.', '#', '.', '.', '.', '.', 'D', '.' },
								{ '.', 'P', '.', '#', '.', 'D', '.', '.', 'Z', '.' },
								{ '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' }};
	
	public GameModel() {
		System.out.print("Model Made");
		player = new Player(0,0,"steve.png");
		level.addLevel(1, levelOne);
		level.addLevel(2, levelTwo);
		//addLevels(1);
		level.initializeLevel(1, player, tileList, enemyList, diamondList, exits);
	}

	 public void addLevels(int numOfLevels) {
			File file = new File("level.txt");
			  try {
			    	Scanner scanner = new Scanner(file);
			    	 
			    	 int level = 1;

					    
					    	
					    	char[][] levelArray = new char[10][10];
					     // String line = scanner.nextLine();
					      for (int y = 0; y < 10;y++) {
					    	 String line = scanner.nextLine();
					    //	 System.out.println(line);
					      for (int x = 0; x < 10; x++) {
					       levelArray[x][y] = line.charAt(x);
					     // System.out.print(line.charAt(x));
					    }
					      }
					      
					    //  System.out.println(levelArray);
					      this.level.addLevel(1,levelArray);
					    
					    scanner.close();
			    } catch (FileNotFoundException e) {
			    	System.out.println("level1.txt not found");
			    }

		}
	 public void nextLevel(int levelNum) {
		 tileList.clear();
		    enemyList.clear();
		    diamondList.clear();
		    exits.clear();

		 level.initializeLevel(levelNum, player, tileList, enemyList, diamondList, exits);
	 }
	 
	
}
