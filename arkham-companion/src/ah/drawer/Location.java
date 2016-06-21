package ah.drawer;

import java.util.ArrayList;

public class Location {
	
	private long ID;
	private String locationName = "";
	
	public Location(long ID, String locName) {
		this.ID = ID;
		locationName = locName;
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

}
