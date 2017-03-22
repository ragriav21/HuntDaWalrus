package myHugePackage;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameMapTest {

	@Test
	public void testDoesMoveStayWithinMapDimensions() {
		GameMap gm = new GameMap(3);
		assertFalse(gm.isPlayerMoveValid(new Coordinate(3, 0)));
		assertFalse(gm.isPlayerMoveValid(new Coordinate(0, 3)));
		assertFalse(gm.isPlayerMoveValid(new Coordinate(-1, -1)));
		assertTrue(gm.isPlayerMoveValid(new Coordinate(0, 0)));
	}
	
	@Test
	public void testDoesBlockedSpaceCountAsInvalid() {
		GameMap gm = new GameMap(3);
		Coordinate testCoordinate = new Coordinate(1, 1);
		gm.addBlockedSpace(testCoordinate);
		assertFalse(gm.isPlayerMoveValid(testCoordinate));
	}

}
