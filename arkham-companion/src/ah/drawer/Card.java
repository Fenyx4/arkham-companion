package ah.drawer;

import java.util.ArrayList;

public class Card {
	
	private long ID;
	private long neiID;
	
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
}
