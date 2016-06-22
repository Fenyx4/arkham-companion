package com.fenyx4.arkham;

import java.util.ArrayList;

public class Location {
	
	private long ID;
	private String locationName = "";
	private ArrayList<OtherWorldColor> otherWorldColors;
	
	public Location(long ID, String locName) {
		this.ID = ID;
		locationName = locName;
		otherWorldColors = null;//new ArrayList<OtherWorldColor>();
	}
	
	public long getID() {
		return ID;
	}
	
	public ArrayList<Encounter> getEncounters() {
		return AHFlyweightFactory.INSTANCE.getEncounters(ID);
	}
	
    @Override public String toString()
    {
    	return getLocationName();
    }

	public String getLocationName() {
		return locationName;
	}

	public String getLocationButtonPath() {
		// TODO Auto-generated method stub
		return "";
	}

	public ArrayList<OtherWorldColor> getOtherWorldColors() {
		if(otherWorldColors == null)
		{
			otherWorldColors = AHFlyweightFactory.INSTANCE.getOtherWorldColors(ID);
		}
		return otherWorldColors;
	}

	public void setOtherWorldColors(ArrayList<OtherWorldColor> otherWorldColors) {
		this.otherWorldColors = otherWorldColors;
	}

	@Override 
	public boolean equals(Object aThat) {
	    //check for self-comparison
	    if ( this == aThat ) return true;

	    // instanceof checks for null already
	    if ( !(aThat instanceof Location) ) return false;

	    Location that = (Location)aThat;

	   
	    return ID == that.getID();
	  }
	
	@Override public int hashCode() {
		int result = 17;
		result = 31 * result + (int) (ID ^ (ID >>> 32));
		
		return result;
	  }
}
