package model;

import java.util.Random;

public class Enemy extends Entity {

	public Enemy(int x, int y, String imgSource) {
		super(x, y, imgSource);
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
