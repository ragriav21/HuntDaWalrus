package myHugePackage;

import java.util.Scanner;

public class GameDriver {

	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the length/width of the map grid you want: ");
		int dimensions = scanner.nextInt();
		GameMap gameMap = generateGameMap(dimensions);
		boolean isGameContinuing = true;
		while(isGameContinuing) {
			
		}
	}
	
	public static GameMap generateGameMap(int dimensions) {
		GameMap gameMap = new GameMap(dimensions);
		int numberOfBlockedSpaces = dimensions < 4 ? 1 : dimensions;
		
	}
	
	public static Coordinate[] addBlockedSpaces(int numberOfBlockedSpaces) {
		Coordinate[] blockedSpaces = new Coordinate[numberOfBlockedSpaces]
	}
}
