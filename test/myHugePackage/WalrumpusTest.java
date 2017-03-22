package myHugePackage;

import static org.junit.Assert.*;

import org.junit.Test;

public class WalrumpusTest {

	public Coordinate c = new Coordinate(0, 0);
	public Coordinate c2 = new Coordinate(4, 4);
	public Walrumpus tempWalrumpus = new Walrumpus(c);

	@Test
	public void test_Is_Eating_Time() {
		tempWalrumpus.setEatingCounter(3);
		assertFalse(tempWalrumpus.isFeedingTime());
		tempWalrumpus.incrementFeedingCounter();
		assertTrue(tempWalrumpus.isFeedingTime());
	}

	@Test
	public void test_Move_Walrumpus_Positive_X() {
		// move in positive x direction
		tempWalrumpus.updateCurrentSpace(new Coordinate(2, 1));
		assertEquals(tempWalrumpus.getCurrentSpace().getX(), (int) 1);
		assertEquals(tempWalrumpus.getCurrentSpace().getY(), (int) 0);
	}
	
	
	@Test
	public void test_Move_Walrumpus_Negative_X() {	
		// move in negative x direction
		tempWalrumpus.setCurrentSpace(c2);
		tempWalrumpus.updateCurrentSpace(new Coordinate(2, 3));
		assertEquals(tempWalrumpus.getCurrentSpace().getX(), (int) 3);
		assertEquals(tempWalrumpus.getCurrentSpace().getY(), (int) 4);
		
	}
	
	@Test
	public void test_Move_Walrumpus_Positive_Y() {
		// move in positive y direction
		tempWalrumpus.setCurrentSpace(c);
		tempWalrumpus.setEatingCounter(1);
		tempWalrumpus.updateCurrentSpace(new Coordinate(1, 2));
		assertEquals(tempWalrumpus.getCurrentSpace().getY(), (int) 1);
		assertEquals(tempWalrumpus.getCurrentSpace().getX(), (int) 0);

	}
	
	@Test
	public void test_Move_Walrumpus_Negative_Y() {
		// move in negative y direction
		tempWalrumpus.setCurrentSpace(c2);
		tempWalrumpus.updateCurrentSpace(new Coordinate(3, 2));
		assertEquals(tempWalrumpus.getCurrentSpace().getY(), (int) 3);
		assertEquals(tempWalrumpus.getCurrentSpace().getX(), (int) 4);
	}
	
	@Test
	public void test_Move_Walrumpus_Feeding_Time() {
		// do not move during feeding time
		tempWalrumpus.setCurrentSpace(c);
		tempWalrumpus.setEatingCounter(4);
		tempWalrumpus.updateCurrentSpace(new Coordinate(1, 1));
		assertEquals(tempWalrumpus.getCurrentSpace().getX(), (int) 0);
		assertEquals(tempWalrumpus.getCurrentSpace().getY(), (int) 0);
		
	}
	
	@Test
	public void test_Move_Walrumpus_Random_Decision() {
		// test random method (while loop that keeps track of counts of x and y
		// decisions? 1,0 0,1
		tempWalrumpus.setCurrentSpace(c);
		tempWalrumpus.updateCurrentSpace(new Coordinate(1, 1));
		int i = 0;
		while ( i < 100) {
		boolean nextCoordinate = (tempWalrumpus.getCurrentSpace().getX() == 1 && tempWalrumpus
				.getCurrentSpace().getY() == 0)
				|| (tempWalrumpus.getCurrentSpace().getX() == 0 && tempWalrumpus
						.getCurrentSpace().getY() == 1);

		assertTrue(nextCoordinate);
		i++;
		}
	}


}