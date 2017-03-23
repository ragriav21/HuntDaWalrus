package myHugePackage;

public class GlobalVariables {
	
	private String outOfBoundsMessage = "Can't move further - You've reached the end of the map!";
	private String blockedSpacesMessage = "Can't move there - There's a wall.";
	private String validMessage = "valid";
	private String WALRUMPUS_ZERO_SPACES_AWAY = "You died, you lost. GAME OVER.";
	private String WALRUMPUS_ONE_SPACE_AWAY = "You smell the wumpus";
	private String WALRUMPUS_TWO_SPACES_AWAY = "'GRRRRRRR'";
	private String WALRUMPUS_THREE_SPACES_AWAY = "You see decaying remains of human bodies.";
	
	public boolean checkCommandValidityWithShoot(String command) {
		return ("w".equals(command) || "a".equals(command) || "s".equals(command) || "d".equals(command) || "q".equals(command));
	}
	
	public boolean checkCommandValidityWithoutShoot(String command) {
		return ("w".equals(command) || "a".equals(command) || "s".equals(command) || "d".equals(command));
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
	public void setBlockedSpacesMessage(String blockedSpacesMessage) {
		this.blockedSpacesMessage = blockedSpacesMessage;
	}
	public String getValidMessage() {
		return validMessage;
	}
	public void setValidMessage(String validMessage) {
		this.validMessage = validMessage;
	}
	
	public String getWALRUMPUS_ZERO_SPACES_AWAY() {
		return WALRUMPUS_ZERO_SPACES_AWAY;
	}
	public void setWALRUMPUS_ZERO_SPACES_AWAY(String wALRUMPUS_ZERO_SPACES_AWAY) {
		WALRUMPUS_ZERO_SPACES_AWAY = wALRUMPUS_ZERO_SPACES_AWAY;
	}
	public String getWALRUMPUS_ONE_SPACE_AWAY() {
		return WALRUMPUS_ONE_SPACE_AWAY;
	}
	public void setWALRUMPUS_ONE_SPACE_AWAY(String wALRUMPUS_ONE_SPACE_AWAY) {
		WALRUMPUS_ONE_SPACE_AWAY = wALRUMPUS_ONE_SPACE_AWAY;
	}
	public String getWALRUMPUS_TWO_SPACES_AWAY() {
		return WALRUMPUS_TWO_SPACES_AWAY;
	}
	public void setWALRUMPUS_TWO_SPACES_AWAY(String wALRUMPUS_TWO_SPACES_AWAY) {
		WALRUMPUS_TWO_SPACES_AWAY = wALRUMPUS_TWO_SPACES_AWAY;
	}
	public String getWALRUMPUS_THREE_SPACES_AWAY() {
		return WALRUMPUS_THREE_SPACES_AWAY;
	}
	public void setWALRUMPUS_THREE_SPACES_AWAY(String wALRUMPUS_THREE_SPACES_AWAY) {
		WALRUMPUS_THREE_SPACES_AWAY = wALRUMPUS_THREE_SPACES_AWAY;
	}

}
