package ah.drawer;

import java.util.ArrayList;

public class Card {
	
	private long ID;
	private long neiID;
	//private ArrayList<Long> expIDs;
	
	public Card(long ID, long neiID) {
		this.ID = ID;
		this.neiID = neiID;
	}
	
	public long getID() {
		return ID;
	}
	
	public ArrayList<Encounter> getEncounters() {
		return AHFlyweightFactory.INSTANCE.getEncountersForCard(ID);
	}
	
    @Override public String toString()
    {
    	return "CardID: " + ID + " NeiID: " + neiID;
    }

	public ArrayList<Long> getExpIDs() {
		return AHFlyweightFactory.INSTANCE.getExpansionsForCard(ID);
	}

	public Neighborhood getNeighborhood() {
		return AHFlyweightFactory.INSTANCE.getNeighborhood(neiID);
		
	}
}
