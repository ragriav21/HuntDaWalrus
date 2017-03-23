package myHugePackage;

import java.util.Stack;

public class Weapon {
		private Stack<Coordinate> shotSpaces;
		
		public Weapon(String shootDirection, Coordinate heroCurrentPosition) {
			addShotSpaces(shootDirection, heroCurrentPosition);
		}
		
		public boolean isWalrumpusHit(Coordinate walrumpusCoordinate) {
			for (Coordinate shotSpace : shotSpaces) {
				if (shotSpace.getX() == walrumpusCoordinate.getX() && shotSpace.getY() == walrumpusCoordinate.getY())
					return true;
			}
			return false;
		}
		
		private void addShotSpaces(String shootDirection, Coordinate heroCurrentPosition) {
			int x = heroCurrentPosition.getX();
			int y = heroCurrentPosition.getY();
			switch (shootDirection.toLowerCase()) {
				case "w": addShotSpace(new Coordinate(x, y + 1));
						  addShotSpace(new Coordinate(x, y + 2));
				case "a": addShotSpace(new Coordinate(x - 1, y));
						  addShotSpace(new Coordinate(x - 2, y));
				case "s": addShotSpace(new Coordinate(x, y - 1));
						  addShotSpace(new Coordinate(x, y - 2));
				case "d": addShotSpace(new Coordinate(x + 1, y));
						  addShotSpace(new Coordinate(x + 2, y));
			}
		}
		
		private void addShotSpace(Coordinate coordinate) {
			shotSpaces.push(coordinate);
		}
	}    

