package myHugePackage;

public class TestThatPlayerCannotMoveThroughBlocks {
	private int x0;
	private int y0;
	private int blockX;
	private int blockY;
	private int size;
	private Hero hero;
	private GameMap gm;
	private String direction;
	public void setMapSize(int s) {
		size = s;
	}
	public void setX0(int x) {
		x0 = x;
	}
	
	public void setY0(int y) {
		y0 = y;
	}

	public void setBlockX(int x) {
		blockX = x;
	}
	public void setBlockY(int y) {
		blockY = y;
	}
	public void setDirection(String dir) {
		direction = dir;
	}
	public int X1() {
		return hero.getCurrentPosition().getX();
	}
	public int Y1() {
		return hero.getCurrentPosition().getY();
	}
	public void execute() {
		gm = new GameMap(size);
		Coordinate startingPosition = new Coordinate(x0, y0);
		hero = new Hero(startingPosition);
		gm.addBlockedSpace(new Coordinate(blockX, blockY));
		Coordinate endingPosition = hero.positionToMoveTo(direction); 
		if (gm.isPlayerMoveValid(endingPosition, false))
			hero.updatePosition(endingPosition);
	}

}