package myHugePackage;

import static org.junit.Assert.*;

import org.junit.Test;

public class HeroTest {
	
	private GlobalVariables globalVariables = new GlobalVariables();
	private Coordinate originalPosition = new Coordinate(1, 1);
	private Hero hero = new Hero(new Coordinate(1, 1));
	
	@Test
	public void testPositionToMoveTo() {
		Coordinate goNorth = hero.positionToMoveTo("w");
		Coordinate goSouth = hero.positionToMoveTo("s");
		Coordinate goWest = hero.positionToMoveTo("a");
		Coordinate goEast = hero.positionToMoveTo("d");
		assertEquals(goNorth.getY(), 2);
		assertEquals(goSouth.getY(), 0);
		assertEquals(goEast.getX(), 2);
		assertEquals(goWest.getX(), 0);
	}

}
