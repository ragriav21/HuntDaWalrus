package myHugePackage;

public class TestPits {
	private GameDriver gameDriver;
	private int playerX;
	private int playerY;
	private int pitX;
	private int pitY;
	
	public void setPlayerX(int x) {
		this.playerX = x;
	}
	
	public void setPlayerY(int y) {
		this.playerY = y;
	}
	
	public void setPitX(int x) {
		this.pitX = x;
	}
	
	public void setPitY(int y) {
		this.pitY = y;
	}
	
	public boolean isPlayerNextToPit() {
		return gameDriver.isPlayerNextToPit();
	}
	
	public boolean isGameOver() {
		return gameDriver.isGameOver();
	}
	
	public boolean isGameWon() {
		return gameDriver.isGameWon();
	}
	
	public void execute() {
		gameDriver = new GameDriver(3);
		gameDriver.generateHeroPosition(new Coordinate(playerX, playerY));
		gameDriver.generatePitSpace(new Coordinate(pitX, pitY));
		if (gameDriver.checkPitCollision()) {
			gameDriver.playerLoses();
		}
	}
}
