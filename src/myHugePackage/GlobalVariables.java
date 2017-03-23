package myHugePackage;

public class GlobalVariables {
	
	private String outOfBoundsMessage = "Can't move further - You've reached the end of the map!";
	private String blockedSpacesMessage = "Can't move there - There's a wall.";
	private String validMessage = "valid";
	
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

}
