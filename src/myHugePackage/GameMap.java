package myHugePackage;

import java.util.Stack;

public class GameMap {
	private int dimension;
	private Stack<Coordinate> blockedSpaces;
	private Stack<Coordinate> batSpaces;
	private Stack<Coordinate> pitSpaces;
	private GlobalVariables globalVariables = new GlobalVariables();
	
	public GameMap(int dimension) {
		this.dimension = dimension;
		blockedSpaces = new Stack<Coordinate>();
		batSpaces = new Stack<Coordinate>();
		pitSpaces = new Stack<Coordinate>();
	}

	public String isPlayerMoveValid(Coordinate coordinate) {
		if (!isCoordinateWithinBounds(coordinate))
			return globalVariables.getOutOfBoundsMessage();
		for (Coordinate block : blockedSpaces) {
			if (coordinate.isEqual(block)) 
				return globalVariables.getBlockedSpacesMessage();
		}
		return globalVariables.getValidMessage();
	}
	
	public boolean isPlayerMoveValid(Coordinate coordinate, boolean flag) {
		if (!isCoordinateWithinBounds(coordinate))
			return false;
		for (Coordinate block : blockedSpaces) {
			if (coordinate.isEqual(block)) 
				return false;
		}
		return true;
	}
	
	public boolean isPlayerMovePitSpace(Coordinate coordinate) {
		for (Coordinate pitSpace : pitSpaces) {
			if (coordinate.isEqual(pitSpace))
				return true;
		}
		return false;
	}
	public boolean isPlayerMoveBatSpace(Coordinate coordinate) {
		for (Coordinate batSpace : batSpaces) {
			if (coordinate.isEqual(batSpace))
				return true;
		}
		return false;
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
		if (isCoordinateWithinBounds(coordinate) && blockedSpaces.search(coordinate) == -1 
				&& batSpaces.search(coordinate) == -1 && pitSpaces.search(coordinate) == -1)
			blockedSpaces.push(coordinate);
	}
	
	// General method for adding coordinates to a stack
	public void addRandomSpaces(Stack<Coordinate> spaceStack) {
		int numberOfSpaces = dimension < 4 ? 1 : dimension - 3;
		for(int i = 0; i < numberOfSpaces; i++) {
			int x = (int) (Math.random() * dimension);
			int y = (int) (Math.random() * dimension);
			Coordinate randomCoordinate = new Coordinate(x, y);
			addToSpaceStack(randomCoordinate, spaceStack);
			randomCoordinate.toString();
		}
	}
	
	// General method for adding a coordinate to a stack
	public void addToSpaceStack(Coordinate coordinate, Stack<Coordinate> spacesStack) {
		if(isCoordinateWithinBounds(coordinate) && blockedSpaces.search(coordinate) == -1 
				&& batSpaces.search(coordinate) == -1 && pitSpaces.search(coordinate) == -1) {
			spacesStack.push(coordinate);
		}
	}

	public void addRandomBatSpaces() {
		int numberOfBatSpaces = dimension < 4 ? 1 : dimension - 3;
		for (int i = 0; i < numberOfBatSpaces; i++) {
			int x = (int) (Math.random() * dimension);
			int y = (int) (Math.random() * dimension);
			Coordinate randomCoordinate = new Coordinate(x, y);
			addBatSpace(randomCoordinate);
			randomCoordinate.toString();
			System.out.println("new bat space"+randomCoordinate.toString());

		}
	}
	
	public void addBatSpace(Coordinate coordinate) {
		if(isCoordinateWithinBounds(coordinate) && blockedSpaces.search(coordinate) == -1 
				&& batSpaces.search(coordinate) == -1 && pitSpaces.search(coordinate) == -1)
			batSpaces.push(coordinate);
	}
	
	public void addRandomPitSpaces() {
		int numberOfPitSpaces = dimension < 4 ? 1 : dimension - 3;
		for(int i = 0; i < numberOfPitSpaces; i++) {
			int x = (int) (Math.random() * dimension);
			int y = (int) (Math.random() * dimension);
			Coordinate randomCoordinate = new Coordinate(x, y);
			addPitSpace(randomCoordinate);
			System.out.println("new ppit space"+randomCoordinate.toString());
		}
	}
	
	public void addPitSpace(Coordinate coordinate) {
		if(isCoordinateWithinBounds(coordinate) && blockedSpaces.search(coordinate) == -1 
				&& batSpaces.search(coordinate) == -1 && (pitSpaces.search(coordinate) == -1))
			pitSpaces.push(coordinate);
	}
	
	
	private boolean isCoordinateWithinBounds(Coordinate coordinate) {
		return ((coordinate.getX() < dimension && coordinate.getY() < dimension) && 
				(coordinate.getX() >= 0 && coordinate.getY() >= 0));
	}
	
}    
