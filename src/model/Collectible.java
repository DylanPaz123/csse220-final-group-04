package model;


public class Collectible extends Entity {
	private int pointWorth = 1;
	
	public Collectible(int x, int y, String imgSource, int pointWorth) {
		super(x,y,imgSource);
		this.pointWorth = pointWorth;
	}
	
	public int getPointWorth() {
		return pointWorth;
	}
	
}
