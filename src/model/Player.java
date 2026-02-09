package model;


public class Player extends Entity {
	
	public int lives = 3;
	public int score = 0;
	public Player(int x, int y, String imgSource) {
		super(x,y,imgSource);
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
