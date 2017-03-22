package myHugePackage;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameMapTest {

	@Test
	public void testIsMoveValid() {
		GameMap gm = new GameMap();
		assertFalse(gm.isPlayerMoveValid(new Coordinate(1, 1)));
		assertFalse(gm.isPlayerMoveValid(new Coordinate(0, 3)));
		assertTrue(gm.isPlayerMoveValid(new Coordinate(0, 0)));
	}

}
