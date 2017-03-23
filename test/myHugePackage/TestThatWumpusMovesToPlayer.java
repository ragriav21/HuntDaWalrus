package myHugePackage;

public class TestThatWumpusMovesToPlayer {
	    
	    private Coordinate startPosition;
	    private Coordinate wStartPosition;
	    private Hero gameHero;
	    private Walrumpus gameWumpus;
	    private int currentDistance;

	    public TestThatWumpusMovesToPlayer(Coordinate startPosition, Coordinate wStartPosition) {
	        this.startPosition = startPosition;
	        this.wStartPosition = wStartPosition;
	        this.gameHero = new Hero(startPosition);
	        this.gameWumpus = new Walrumpus(wStartPosition);
	        this.currentDistance = gameWumpus.calculateDistanceToPlayer(gameHero.getCurrentPosition());
	    }

	    public int DistanceIs() {
	        return this.currentDistance;
	    }

	    public void wumpusMoves() {
	        this.gameWumpus.updateCurrentSpace(this.startPosition);
	        this.currentDistance = gameWumpus.calculateDistanceToPlayer(gameHero.getCurrentPosition());
	    }

	
}
