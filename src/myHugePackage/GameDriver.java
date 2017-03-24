package myHugePackage;

import java.util.Scanner;

public class GameDriver {
	private static GlobalVariables globalVariables = new GlobalVariables();
	private GameMap gameMap;
	private int dimensions;
	private Coordinate initialHeroPosition;
	private Coordinate initialWalrumpusPosition;
	private Hero hero;
	private Walrumpus walrumpus;
	private boolean gameOver;
	private boolean gameWon;
	
	public GameDriver(int dimensions) {
		this.dimensions = dimensions;
		gameMap = new GameMap(dimensions);
		gameMap.addRandomBlockedSpaces();
		gameOver = false;
		gameWon = false;
	}
	
	public void addRandomBatSpaces() {
		gameMap.addRandomBatSpaces();
	}
	
	public void addRandomPitSpaces() {
		gameMap.addRandomPitSpaces();
	}
	
	public void generateRandomStarts() {
		initialHeroPosition = generateRandomCoordinate(dimensions, gameMap);
		initialWalrumpusPosition = generateRandomCoordinate(
				dimensions, gameMap);
		hero = new Hero(initialHeroPosition);
		
		while (initialHeroPosition.isEqual(initialWalrumpusPosition)) {
			initialWalrumpusPosition = generateRandomCoordinate(dimensions,
					gameMap);
		}
		walrumpus = new Walrumpus(initialWalrumpusPosition);
	}
	
	public void batRandomCoordinate() {
		int x = (int) (Math.random() * this.dimensions);
		int y = (int) (Math.random() * this.dimensions);
		Coordinate coordinateToMoveTo = new Coordinate(x, y);
		// bat cannot move player to a special block or the walrus's block
		if (gameMap.isPlayerMoveBatSpace(coordinateToMoveTo) || !gameMap.isPlayerMoveValid(coordinateToMoveTo, true) 
				|| coordinateToMoveTo.isEqual(walrumpus.getCurrentSpace())) {
			batRandomCoordinate();
		}
		this.moveHero(coordinateToMoveTo);
		
	}
	
	public void generateHeroPosition(Coordinate coordinate) {
		hero = new Hero(coordinate);
	}
	
	public void generateWalrumpusPosition(Coordinate coordinate) {
		walrumpus = new Walrumpus(coordinate);
	}
	
	public void generatePitSpace(Coordinate coordinate) {
		gameMap.addPitSpace(coordinate);
	}
	
	public void generateBatSpace(Coordinate coordinate) {
		gameMap.addBatSpace(coordinate);
	}
	
	public Coordinate generateRandomCoordinate(int dimension, GameMap gameMap) {
		int x = (int) (Math.random() * dimension);
		int y = (int) (Math.random() * dimension);
		Coordinate initialCoordinate = new Coordinate(x, y);
		if (!gameMap.isPlayerMoveValid(initialCoordinate, true)) {
			generateRandomCoordinate(dimension, gameMap);
		}
		return initialCoordinate;
	}
	
	public boolean doesShotHitWalrumpus(String shootDirection) {
		Weapon weapon = new Weapon(shootDirection, hero.getCurrentPosition());
		return weapon.isWalrumpusHit(walrumpus.getCurrentSpace());
	}
	
	public Coordinate getNewPosition(String command) {
		return hero.positionToMoveTo(command);
	}
	
	public String checkMoveValidity(Coordinate newHeroPosition) {
		return gameMap.isPlayerMoveValid(newHeroPosition);
	}
	
	public void moveHero(Coordinate newHeroPosition) {
		hero.updatePosition(newHeroPosition);
	}
	
	public void moveWalrumpus() {
		walrumpus.updateCurrentSpace(hero.getCurrentPosition());
	}
	
	public boolean checkWalrumpusCollision() {
		return hero.getCurrentPosition().isEqual(walrumpus.getCurrentSpace());
	}
	
	public boolean checkBatCollision() {
		return this.gameMap.isPlayerMoveBatSpace(hero.getCurrentPosition());
	}
	
	public boolean checkPitCollision() {
		return this.gameMap.isPlayerMovePitSpace(hero.getCurrentPosition());
	}
	
	public int findDistanceBetweenHeroAndWalrumpus() {
		return walrumpus.calculateDistanceToPlayer(hero.getCurrentPosition());
	}
	
	public boolean isPlayerNextToBats() {
		return gameMap.isPlayerNextToBats(hero.getCurrentPosition());
	}
	
	public boolean isPlayerNextToPit() {
		return gameMap.isPlayerNextToPit(hero.getCurrentPosition());
	}
	
	public Coordinate getCurrentHeroPosition() {
		return hero.getCurrentPosition();
	}
	public void playerLoses() {
		gameOver = true;
		gameWon = false;
	}
	
	public void playerWins() {
		gameOver = true;
		gameWon = true;
	}
	
	public boolean isGameOver() {
		return gameOver;
	}
	
	public boolean isGameWon() {
		return gameWon;
	}
	
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		String enterSideLengthMessage = globalVariables.getEnterSideLengthMessage();
		System.out.print(enterSideLengthMessage);
		int dimensions = scanner.nextInt();
		boolean continuePlaying = true;
		while (continuePlaying) {
		while (dimensions < 3) {
			System.out.println("Side length must be at least 3.");
			System.out.print(enterSideLengthMessage);
			dimensions = scanner.nextInt();
		}
		GameDriver gameDriver = new GameDriver(dimensions);
		gameDriver.generateRandomStarts();
		gameDriver.addRandomBatSpaces();
		gameDriver.addRandomPitSpaces();
		printDirections();
		boolean isGameContinuing = true;
		while (isGameContinuing) {
			System.out.println("Select what you want to do or where you want to move next.");
			String command = scanner.next();
			if(!globalVariables.checkCommandValidityWithShoot(command)) {
				System.out.println("This is not a valid command. Read the directions.");
				continue;
			} 
			// shoot
			else if ("q".equals(command)) {
				System.out.println("In which direction do you want to shoot?");
				String shootDirection = scanner.next();
				if(!globalVariables.checkCommandValidityWithoutShoot(shootDirection)) {
					System.out.println("This is not a valid command. Read the directions.");
					continue;
				}
				if (gameDriver.doesShotHitWalrumpus(shootDirection)) {
					System.out.println("Congratulations!  You killed the Walrus.  Turns out he was your father.  You win.  For what it's worth.");
					gameDriver.playerWins();
					break;
				} else {
					System.out.println("You did not hit the Walrus.  Were you a stormtrooper in your past life?");
				}
			}
			// move
			else {
				Coordinate newHeroPosition = gameDriver.getNewPosition(command);
				String moveValidity = gameDriver.checkMoveValidity(newHeroPosition);
				// Adding clauses for pits and bats.
				if (globalVariables.getValidMessage().equals(moveValidity)) {
					gameDriver.moveHero(newHeroPosition);
					System.out.println("Hero Moved to " + newHeroPosition.toString());
					if (gameDriver.checkWalrumpusCollision()) {
						System.out.println("You stumbled upon the Walrus and he eviscerated you. Game Over.");
						gameDriver.playerLoses();
						break;
					}
					else if (gameDriver.checkPitCollision()) {
						System.out.println("You have fallen into an impossible gravity well, stuck there forever contemplating how stupid you were to go hunt a Walrus.");
						gameDriver.playerLoses();
						break;
					}
					else if (gameDriver.checkBatCollision()) {
						System.out.println("You've run into a load of bats.  A crazy man in a batsuit grabs you from behind and throws you down a hole.");
						gameDriver.batRandomCoordinate();
					}
					else if (gameDriver.isPlayerNextToBats()) {
						System.out.println(globalVariables.getBatMessage());
					}
					else if (gameDriver.isPlayerNextToPit()) {
						System.out.println(globalVariables.getPitMessage());
					}
				} else {
					System.out.println(moveValidity);
					continue;
				}
			}
			// walrus moves
			gameDriver.moveWalrumpus();
			int distance = gameDriver.findDistanceBetweenHeroAndWalrumpus();
			
			if (distance == 0) {
				System.out.println("The Walrus found you.  For an instant, you feel a searing pain, as you see your guts spill out from your stomach.  Then, darkness. Game Over.");
				gameDriver.playerLoses();
				break;
			} else if (distance <= 3) {
				printWalrumpusWarning(distance);
			}
		}
		System.out.println("Do you wish to continue playing?  Press r to start over, press anything else to terminate the game.");
		String playerResponse = scanner.next();
		if (!playerResponse.equals("r")) 
			continuePlaying=false;
		}
		scanner.close();
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

	
	private static void printWalrumpusWarning(int distance) {
		
		String warningMessage  = "";
		switch (distance) {
		
		case 1:
			warningMessage = globalVariables.getWalrumpusOneSpaceAway();
			System.out.println(warningMessage);
			break;

		case 2: 
			warningMessage = globalVariables.getWalrumpusTwoSpacesAway();
			System.out.println(warningMessage);
			break;
		
		case 3: 
			warningMessage = globalVariables.getWalrumpusThreeSpacesAway();
			System.out.println(warningMessage);
			break;
			
		default: 
			break;
		}
	}


}
