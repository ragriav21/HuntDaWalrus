package myHugePackage;

public class Walrumpus {

    private int eatingCounter;
  

	private Coordinate currentSpace;
    
    public Walrumpus (Coordinate startSpace) {
        setCurrentSpace(startSpace);
        eatingCounter = 1;
    }

    private void updateCurrentSpace() {
        if (isFeedingTime()) {
     //       Map.moveWalrumpus();
        }
    }

    protected void incrementEatingCounter() {
        eatingCounter++;
    }

    protected Boolean isFeedingTime() {
            return (eatingCounter%4 == 0);
    }
    
    public int getEatingCounter() {
  		return eatingCounter;
  	}

	public void setEatingCounter(int eatingCounter) {
		this.eatingCounter = eatingCounter;
	}

	public Coordinate getCurrentSpace() {
		return currentSpace;
	}

	public void setCurrentSpace(Coordinate currentSpace) {
		this.currentSpace = currentSpace;
	}


}