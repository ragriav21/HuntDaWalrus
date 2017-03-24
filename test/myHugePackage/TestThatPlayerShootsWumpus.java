package myHugePackage;

public class TestThatPlayerShootsWumpus {
	private int playerX;
	private int playerY;
	private int walrusX;
	private int walrusY;
	private GameDriver gameDriver;
	private String direction;

	public void setPlayerX(int x) {
		this.playerX = x;
	}

	public void setPlayerY(int y) {
		this.playerY = y;
	}

	public void setWalrusX(int x) {
		this.walrusX = x;
	}

	public void setWalrusY(int y) {
		this.walrusY = y;
	}

	public void setShootingDirection(String shootingDirection) {
		this.direction = shootingDirection;
	}
	
	public boolean isWalrusDead() {
		return gameDriver.doesShotHitWalrumpus(direction);
	}

	public void execute() {
		GameDriver gameDriver = new GameDriver(3);
		gameDriver.generateHeroPosition(new Coordinate(playerX, playerY));
		gameDriver.generateWalrumpusPosition(new Coordinate(walrusX, walrusY));
	}
}
