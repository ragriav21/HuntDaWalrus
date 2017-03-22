package myHugePackage;

import java.util.Stack;

public class GameMap {
	private int dimension;
	private Stack<Coordinate> blockedSpaces;
	
	public GameMap(int dimension) {
		this.dimension = dimension;
		blockedSpaces = new Stack<Coordinate>();
	}

	public boolean isPlayerMoveValid(Coordinate c) {
		if (c.getX() >= dimension || c.getY() >= dimension || c.getX() < 0 || c.getY() < 0)
			return false;
		for (Coordinate block : blockedSpaces) {
			if (c.getX() == block.getX() && c.getY() == block.getY()) 
				return false;
		}
		return true;
	}
	public void addBlockedSpace(Coordinate c) {
		blockedSpaces.push(c);
	}
}    