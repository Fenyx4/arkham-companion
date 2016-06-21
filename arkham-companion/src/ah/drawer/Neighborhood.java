package ah.drawer;

public class Neighborhood {
	
	private long ID;
	private String neighborhoodName = "";
	private String cardPath = "";
	
	public Neighborhood(long ID, String neiName, String cardPath) {
		this.ID = ID;
		neighborhoodName = neiName;
		this.cardPath = cardPath;
	}
	
	public long getID() {
		return ID;
	}

	/*
	public ArrayList<Location> getLocations() {
		return AHFlyweightFactory.INSTANCE.getLocations(ID);
	}
	*/
    @Override public String toString()
    {
    	return getNeighborhoodName();
    }

	public String getNeighborhoodName() {
		return neighborhoodName;
	}

	public String getCardPath() {
		return cardPath;
	}

}
