package com.fenyx4.arkham;

public class Neighborhood {
	
	private long ID;
	private String neighborhoodName = "";
	private String cardPath = "";
	private String neighborhoodButtonPath = "";
	
	public Neighborhood(long ID, String neiName, String cardPath, String neighborhoodButtonPath) {
		this.ID = ID;
		neighborhoodName = neiName;
		this.cardPath = cardPath;
		this.neighborhoodButtonPath = neighborhoodButtonPath;
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

	public String getNeighborhoodButtonPath() {
		return neighborhoodButtonPath;
	}

}
