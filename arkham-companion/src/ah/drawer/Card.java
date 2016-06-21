package ah.drawer;

import java.util.ArrayList;

public class Card {
	
	private long ID;
	private long neiID;
	private long expID;
	
	public Card(long ID, long neiID, long expID) {
		this.ID = ID;
		this.neiID = neiID;
		this.expID = expID;
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

	public long getExpID() {
		return expID;
	}

	public Neighborhood getNeighborhood() {
		return AHFlyweightFactory.INSTANCE.getNeighborhood(neiID);
		
	}
}
