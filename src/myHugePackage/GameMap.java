package myHugePackage; 

public class GameMap {
	private int dimension;
	private Coordinate[] spacesWithBlocks;
	
	public GameMap() {
		dimension = 3;
		spacesWithBlocks = new Coordinate[1];
		spacesWithBlocks[0] = new Coordinate(1, 1);
	}

	public boolean isPlayerMoveValid(Coordinate c) {
		if (c.getX() >= dimension || c.getY() >= dimension)
			return false;
		for (int i = 0; i < spacesWithBlocks.length; i++) {
			if (spacesWithBlocks[i].getX() == c.getX() && spacesWithBlocks[i].getY() == c.getY())
				return false;
		}
		return true;
	}
}