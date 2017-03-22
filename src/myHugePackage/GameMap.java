package myHugePackage;

import java.util.Stack;

public class GameMap {
	private int dimension;
	private Stack<Coordinate> blockedSpaces;
	
	public GameMap(int dimension) {
		this.dimension = dimension;
		blockedSpaces = new Stack<Coordinate>();
	}

	public boolean isPlayerMoveValid(Coordinate coordinate) {
		if (!isCoordinateWithinBounds(coordinate))
			return false;
		for (Coordinate block : blockedSpaces) {
			if (coordinate.getX() == block.getX() && coordinate.getY() == block.getY()) 
				return false;
		}
		return true;
	}
	
	public void addRandomBlockedSpaces() {
		int numberOfBlockedSpaces = dimension < 4 ? 1 : dimension;
		for(int i = 0; i < numberOfBlockedSpaces; i++) {
			int x = (int) (Math.random() * dimension);
			int y = (int) (Math.random() * dimension);
			Coordinate randomCoordinate = new Coordinate(x, y);
			addBlockedSpace(randomCoordinate);
		}
	}
	
	public void addBlockedSpace(Coordinate coordinate) {
		if(isCoordinateWithinBounds(coordinate))
			blockedSpaces.push(coordinate);
	}
	
	private boolean isCoordinateWithinBounds(Coordinate coordinate) {
		return (coordinate.getX() >= dimension || coordinate.getY() >= dimension || 
				coordinate.getX() < 0 || coordinate.getY() < 0);
	}
}    