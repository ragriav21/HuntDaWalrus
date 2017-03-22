public class TestThatPlayerCanMoveToConnectedCaverns {
	private int x0;
	private int y0;
	private int x1;
	private int y1;
	private String direction; 

	public void setX0(int x) {
		x0 = x;
	}
	public void setY0(int y) {
		y0 = y;
	}
	public void setX1(int x) {
		x1 = x;
	}
	public void setY1(int y) {
		y1 = y;
	}
	public void setDirection(String dir) {
		direction = dir;
	}
	public void execute() {
		Coordinate startingPosition = new Coordinate(x0, y0);
		Hero hero = new Hero(startingPosition);
		hero.updatePosition(direction);
		return hero.getCurrentPosition();
	}
}