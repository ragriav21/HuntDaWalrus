package myHugePackage;

import java.util.Stack;

public class Weapon {
		private Stack<Coordinate> shotSpaces;
		
		public Weapon(String shootDirection, Coordinate heroCurrentPosition) {
			shotSpaces = new Stack<Coordinate>();
			addShotSpaces(shootDirection, heroCurrentPosition);
		}
		
		public boolean isWalrumpusHit(Coordinate walrumpusCoordinate) {
			for (Coordinate shotSpace : shotSpaces) {
				if (shotSpace.isEqual(walrumpusCoordinate))
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
						  break;
				case "a": addShotSpace(new Coordinate(x - 1, y));
						  addShotSpace(new Coordinate(x - 2, y));
						  break;
				case "s": addShotSpace(new Coordinate(x, y - 1));
						  addShotSpace(new Coordinate(x, y - 2));
						  break;
				case "d": addShotSpace(new Coordinate(x + 1, y));
						  addShotSpace(new Coordinate(x + 2, y));
						  break;
			}
		}
		
		private void addShotSpace(Coordinate coordinate) {
			shotSpaces.push(coordinate);
		}
	}    

