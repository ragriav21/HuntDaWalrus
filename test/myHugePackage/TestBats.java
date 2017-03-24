package myHugePackage;

public class TestBats {
	private GameDriver gameDriver;
	private int playerX;
	private int playerY;
	private int batX;
	private int batY;
	
	public void setPlayerX(int x) {
		this.playerX = x;
	}
	
	public void setPlayerY(int y) {
		this.playerY = y;
	}
	
	public void setBatX(int x) {
		this.batX = x;
	}
	
	public void setBatY(int y) {
		this.batY = y;
	}
	
	public boolean isPlayerNextToBat() {
		return gameDriver.isPlayerNextToBats();
	}
	
	public int playerEndX() {
		return gameDriver.getCurrentHeroPosition().getX();
	}
	
	public int playerEndY() {
		return gameDriver.getCurrentHeroPosition().getY();
	}
	
	public void execute() {
		gameDriver = new GameDriver(3);
		gameDriver.generateHeroPosition(new Coordinate(playerX, playerY));
		gameDriver.generateBatSpace(new Coordinate(batX, batY));
		if (gameDriver.checkBatCollision()) {
			gameDriver.batRandomCoordinate();
		}
	}
}
