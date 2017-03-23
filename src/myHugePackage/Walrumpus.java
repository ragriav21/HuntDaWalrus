package myHugePackage;

public class Walrumpus {

	private int eatingCounter;

	private Coordinate currentSpace;

	private Coordinate newCoordinate;

	public Walrumpus(Coordinate startSpace) {
		setCurrentSpace(startSpace);
		eatingCounter = 1;
	}

	protected void updateCurrentSpace(Coordinate playerCoordinate) {
		if (!isFeedingTime()) {
			this.setCurrentSpace(moveWalrumpus(playerCoordinate));
		}
		if (!this.isFeedingTime()) {
//			System.out.println("Walrus moved to "
//					+ this.getCurrentSpace().toString());
		} else if (this.isFeedingTime()) {
			System.out.println("'OM NOM NOM NOM'");
//			System.out.println("Walrus is stationed at "
//					+ this.getCurrentSpace().toString());
		}
		this.incrementFeedingCounter();
	}
	
	protected int calculateDistanceToPlayer(Coordinate playerCoordinate) {
		int xDistance = Math.abs(playerCoordinate.getX() - currentSpace.getX());
		int yDistance = Math.abs(playerCoordinate.getY() - currentSpace.getY());
		
		return xDistance + yDistance;
	}

	protected void incrementFeedingCounter() {
		eatingCounter++;
	}

	protected Boolean isFeedingTime() {
		return (eatingCounter % 4 == 0);
	}

	protected Coordinate moveWalrumpus(Coordinate playerCoordinate) {
		int xDistance = playerCoordinate.getX() - currentSpace.getX();
		int yDistance = playerCoordinate.getY() - currentSpace.getY();
		Coordinate newCoordinate = new Coordinate();
		if (Math.abs(xDistance) > Math.abs(yDistance)) {
			newCoordinate = incrementPostionByX(playerCoordinate, xDistance);
		}
		if (Math.abs(xDistance) < Math.abs(yDistance)) {
			newCoordinate = incrementPositionByY(playerCoordinate, yDistance);
		}
		else if (Math.abs(xDistance) == Math.abs(yDistance)) {

			if (isRandomDirectionX()) {
				newCoordinate = incrementPostionByX(playerCoordinate, xDistance);
			}
			else {
				newCoordinate = incrementPositionByY(playerCoordinate, yDistance);
			}
		}
		
		return newCoordinate;
		
		
	}
	
	private Coordinate incrementPostionByX(Coordinate playerCoordinate, int xDistance) {
		if (xDistance > 0) {
			return new Coordinate(currentSpace.getX() + 1, currentSpace.getY());
		}
		if (xDistance < 0) {
			return new Coordinate(currentSpace.getX() -1, currentSpace.getY());
		}
		else return new Coordinate();
	}
	
	private Coordinate incrementPositionByY(Coordinate playerCoordinate, int yDistance) {
		if (yDistance > 0) {
			return new Coordinate(currentSpace.getX(), currentSpace.getY() + 1);
		}
		if (yDistance < 0) {
			return new Coordinate(currentSpace.getX(), currentSpace.getY() -1);
		}
		else return new Coordinate();
	}
	
	private Boolean isRandomDirectionX() {
		double randomNumber = Math.floor(Math.random() + 0.5);
		return (randomNumber == 0);
	}
	
	public int getEatingCounter() {
		return eatingCounter;
	}

	public void setEatingCounter(int eatingCounter) {
		this.eatingCounter = eatingCounter;
	}

	public Coordinate getCurrentSpace() {
		return currentSpace;
	}

	public void setCurrentSpace(Coordinate currentSpace) {
		this.currentSpace = currentSpace;
	}


}