package myHugePackage;

public class HTWScripts {
	    
	    private Coordinate startPosition;
	    private Coordinate wStartPosition;
	    private Hero gameHero;
	    private Walrumpus gameWumpus;
	    private int currentDistance = 0;
	    
	    public HTWScripts() {
	    	System.out.println("First line of consts");
	    }
	    public void PutPlayerIn(String playerCoordinate) {	
	    	System.out.println(playerCoordinate);
	    	int xCoord = Integer.parseInt(playerCoordinate.substring(0, 1));
	    	int yCoord = Integer.parseInt(playerCoordinate.substring(2, 3));
	    	System.out.println(xCoord);
	    	System.out.println(yCoord);
	    	this.startPosition = new Coordinate(xCoord, yCoord);
	        this.gameHero = new Hero(startPosition);
	    }
	    
	    public void PutWumpusIn(String wumpusCoordinate) {
	    	int xCoord = Integer.parseInt(wumpusCoordinate.substring(0, 1));
	    	int yCoord = Integer.parseInt(wumpusCoordinate.substring(2, 3));

	    	this.wStartPosition = new Coordinate(xCoord, yCoord);
	    	this.gameWumpus = new Walrumpus(wStartPosition);
	    }

	    public void distanceIs() {	
	      //  return this.currentDistance;
	    	System.out.println(currentDistance);
	    }
	    
	    public int GetDistance() {
//	    	return false;
	        this.currentDistance = gameWumpus.calculateDistanceToPlayer(gameHero.getCurrentPosition());
	        System.out.println("This is current distance");
	        System.out.println(currentDistance);
	        return this.currentDistance;
//	    	return 1;
	    }
	    
	    public void saveDistance() {
	    	this.currentDistance=2;
	    }
	    
//	    public boolean newDistanceLess() {
//	    	return this.currentDistance > 1;
//	    }
	    
	    public int WumpusCrawls() {
	    	System.out.println("wumpus crawling");
	    	return 1;
	    }

	    public void WumpusMoves() {
	        this.gameWumpus.updateCurrentSpace(this.startPosition);
	        this.currentDistance = gameWumpus.calculateDistanceToPlayer(gameHero.getCurrentPosition());
	    }
	
}
