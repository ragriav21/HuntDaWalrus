package myHugePackage;

import java.util.Stack;

public class GameMap {
	private int dimension;
	private Stack<Coordinate> blockedSpaces;
	private GlobalVariables globalVariables = new GlobalVariables();
	
	public GameMap(int dimension) {
		this.dimension = dimension;
		blockedSpaces = new Stack<Coordinate>();
	}

	public String isPlayerMoveValid(Coordinate coordinate) {
		if (!isCoordinateWithinBounds(coordinate))
			return globalVariables.getOutOfBoundsMessage();
		for (Coordinate block : blockedSpaces) {
			if (coordinate.getX() == block.getX() && coordinate.getY() == block.getY()) 
				return globalVariables.getBlockedSpacesMessage();
		}
		return globalVariables.getValidMessage();
	}
	
	public void addRandomBlockedSpaces() {
		int numberOfBlockedSpaces = dimension < 4 ? 1 : dimension;
		for(int i = 0; i < numberOfBlockedSpaces; i++) {
			int x = (int) (Math.random() * dimension);
			int y = (int) (Math.random() * dimension);
			Coordinate randomCoordinate = new Coordinate(x, y);
			addBlockedSpace(randomCoordinate);
			randomCoordinate.toString();
		}
	}
	
	public void addBlockedSpace(Coordinate coordinate) {
		if(isCoordinateWithinBounds(coordinate) && blockedSpaces.search(coordinate) == -1)
			blockedSpaces.push(coordinate);
	}
	
	private boolean isCoordinateWithinBounds(Coordinate coordinate) {
		return ((coordinate.getX() < dimension && coordinate.getY() < dimension) && 
				(coordinate.getX() >= 0 && coordinate.getY() >= 0));
	}
}    