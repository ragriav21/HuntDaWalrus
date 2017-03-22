package myHugePackage;

import java.util.Scanner;

public class GameDriver {
	private static GlobalVariables globalVariables = new GlobalVariables();
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the length/width (one number for both) of the map grid you want: ");
		int dimensions = scanner.nextInt();
		
		GameMap gameMap = new GameMap(dimensions);
		gameMap.addRandomBlockedSpaces();
		Coordinate initialPosition = new Coordinate(0, 0);
		Hero hero = new Hero(initialPosition);
		
		boolean isGameContinuing = true;
		printDirections();
		
		while(isGameContinuing) {
			System.out.println("In which direction do you want to move?");
			String direction = scanner.next();
			Coordinate newPosition = hero.positionToMoveTo(direction);
			String moveValidity = gameMap.isPlayerMoveValid(newPosition);
			if (globalVariables.getValidMessage().equals(moveValidity)) {
				hero.updatePosition(newPosition);
				System.out.println("Hero Moved to " + newPosition.toString());
			}
			else System.out.println(moveValidity);	
		}
	}
	
	public static void printDirections() {
		System.out.println("Welcome to Hunt the Walrus! The objective of the game is to either: ");
		System.out.println("a) Kill the Walrus using the bows and arrows with which you're equipped, ");
		System.out.println("b) Escape the maze by reaching the hidden exit (you'll see a light when you're near it).");
		System.out.println("Each turn, you have the option of either trying to reach the exit by typing one of four directional keys into the command line");
		System.out.println("('w' to go up, 'a' to go left, 's' to go down, and 'd' to go right), or to try and kill the Walrus ");
		System.out.println("(he's hunting you, and you can't see him but you can see his victims, hear him, and at worse, smell him), by shooting your arrows in the direction you think he's located");
		System.out.println("(type 'q' to access your weapons, and then type 'w' to shoot up, 'a' to shoot left, 's' to shoot down, and 'd' to shoot right, with bows reaching up to two spaces in one direction).");
		System.out.println("Watch out for bats, who'll fly you to random locations, and pits, from which you cannot escape if you fall in!");
		System.out.println();
	}

}
