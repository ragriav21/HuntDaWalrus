package myHugePackage;

import Coordinate;
import GameMap;

public class Player {

    public Player (Coordinate startSpace) {
        currentSpace = startSpace;
    }
    private Coordinate currentSpace;

	private void updateCurrentSpace(Coordinate coordinate) {
       if (GameMap.isPlayerMoveValid(coordinate) {
    	  this.setCurrentSpace(coordinate);
       }
    }

    public Coordinate getCurrentSpace() {
		return currentSpace;
	}

	public void setCurrentSpace(Coordinate currentSpace) {
		this.currentSpace = currentSpace;
	}

}