package myHugePackage.sut;

public class Hero {
	private Coordinate currentPosition;
		
	public Hero(Coordinate coordinate) {
		currentPosition = coordinate;
	}
	
	public void updatePosition(Coordinate newPosition) {
		currentPosition = newPosition;
	}
	
	public Coordinate positionToMoveTo(String direction) {
		int x = currentPosition.getX();
		int y = currentPosition.getY();
		switch (direction.toLowerCase()) {
			case "w": return new Coordinate(x, y + 1);
			case "a": return new Coordinate(x - 1, y);
			case "s": return new Coordinate(x, y - 1);
			case "d": return new Coordinate(x + 1, y);
			default : return currentPosition;
		}
	}
}
