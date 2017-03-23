package myHugePackage;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import myHugePackage.Coordinate;
import myHugePackage.GameMap;
import myHugePackage.GlobalVariables;

public class GameMapTest {

	private GlobalVariables globalVariables = new GlobalVariables();
	
	@Test
	public void testDoesMoveStayWithinMapDimensions() {
		GameMap gm = new GameMap(3);
		assertEquals(gm.isPlayerMoveValid(new Coordinate(3, 0)), globalVariables.getOutOfBoundsMessage());
		assertEquals(gm.isPlayerMoveValid(new Coordinate(0, 3)), globalVariables.getOutOfBoundsMessage());
		assertEquals(gm.isPlayerMoveValid(new Coordinate(-1, -1)), globalVariables.getOutOfBoundsMessage());
		assertEquals(gm.isPlayerMoveValid(new Coordinate(0, 0)), globalVariables.getValidMessage());
	}
	
	@Test
	public void testDoesBlockedSpaceCountAsInvalid() {
		GameMap gm = new GameMap(3);
		Coordinate testCoordinate = new Coordinate(1, 1);
		gm.addBlockedSpace(testCoordinate);
		assertEquals(gm.isPlayerMoveValid(testCoordinate), globalVariables.getBlockedSpacesMessage());
	}

}
