package model;

public interface Character {
	public void move();
	public int[][] getSurroundingTiles(int curX, int curY);

}
