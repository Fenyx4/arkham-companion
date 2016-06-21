package ah.drawer;

public class Neighborhood {
	
	private long ID;
	private String neighborhoodName = "";
	
	public Neighborhood(long ID, String neiName) {
		this.ID = ID;
		neighborhoodName = neiName;
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

}
