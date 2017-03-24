package myHugePackage;

public class GlobalVariables {
	
	private String enterSideLengthMessage = "Enter the side length (one integer) of the map grid you want for this session: ";
	private String outOfBoundsMessage = "Can't move further - You've reached the end of the map!";
	private String blockedSpacesMessage = "Can't move there - There's a wall.";
	private String validMessage = "valid";
	private String WALRUMPUS_ZERO_SPACES_AWAY = "You died, you lost. GAME OVER.";
	private String WALRUMPUS_ONE_SPACE_AWAY = "You smell the wumpus";
	private String WALRUMPUS_TWO_SPACES_AWAY = "'GRRRRRRR'";
	private String WALRUMPUS_THREE_SPACES_AWAY = "You see decaying remains of human bodies.";
	private String batMessage = "You hear a faint whisper: 'I am the night...'";
	private String pitMessage = "You feel a pit in your stomach...and also somewhere near you.";
	
	public String getBatMessage() {
		return batMessage;
	}

	public String getPitMessage() {
		return pitMessage;
	}

	public boolean checkCommandValidityWithShoot(String command) {
		return ("w".equals(command) || "a".equals(command) || "s".equals(command) || "d".equals(command) || "q".equals(command));
	}
	
	public boolean checkCommandValidityWithoutShoot(String command) {
		return ("w".equals(command) || "a".equals(command) || "s".equals(command) || "d".equals(command));
	}
	
	public String getEnterSideLengthMessage() {
		return enterSideLengthMessage;
	}
	
	public String getOutOfBoundsMessage() {
		return outOfBoundsMessage;
	}
	public void setOutOfBoundsMessage(String outOfBoundsMessage) {
		this.outOfBoundsMessage = outOfBoundsMessage;
	}
	public String getBlockedSpacesMessage() {
		return blockedSpacesMessage;
	}

	public String getValidMessage() {
		return validMessage;
	}
	
	public String getWALRUMPUS_ZERO_SPACES_AWAY() {
		return WALRUMPUS_ZERO_SPACES_AWAY;
	}

	public String getWalrumpusOneSpaceAway() {
		return WALRUMPUS_ONE_SPACE_AWAY;
	}

	public String getWalrumpusTwoSpacesAway() {
		return WALRUMPUS_TWO_SPACES_AWAY;
	}

	public String getWalrumpusThreeSpacesAway() {
		return WALRUMPUS_THREE_SPACES_AWAY;
	}

}
